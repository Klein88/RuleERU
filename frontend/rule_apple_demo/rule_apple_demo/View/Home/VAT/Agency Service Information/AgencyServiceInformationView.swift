//
//  AgencyServiceInformationView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/16.
//

import SwiftUI
import Moya
struct AgencyServiceInformationView: View {
    @State var selection : Int = 0
    @State var taxDeclaration = TaxdeclarationRequestrecord(vatnumber: "", taxrate: 0.00, taxnumbereffectivedate: "", lastdeclarationdate: "", gatewayid: "", gatewaypassword: "", lastreporteddate: "", mtdusername: "", mtdpassword: "", companyregistrationlocation: "", companyname: "", businesslicensenumber: "", companyestablishmentdate: "", companyoperationaladdress: "", postalcode: "", companyphonenumber: "", companycontactemail: "", legalrepresentativename: "", mainsalesplatform: "", shopname: "", informationlink: "", shopbackendselleraddress: "", shopbackendcompanyname: "", mainbusinessscope: "")
    @State var LastDeclarationDate : Date = Date()
    @State var TaxNumberEffectiveDate : Date = Date()
    @State var LastReportedDate : Date = Date()
    @State var CompanyEstablishmentDate : Date = Date()
    @State var isuploaddocument : Bool = false
    @State var lastnumber : Int = 0
    @State var isupload : Bool = false
    var body: some View {
        NavigationView{
            VStack
            {
                TabView(selection: $selection){
                    AgencyServiceInformationView_VAT(TaxNumberEffectiveDate: $TaxNumberEffectiveDate, LastDeclarationDate: $LastDeclarationDate, VATNumber: $taxDeclaration.vatnumber, LastReportedDate: $LastReportedDate, GatewayID: $taxDeclaration.gatewayid, GatewayPassword: $taxDeclaration.gatewaypassword, MTDUsername: $taxDeclaration.mtdusername, MTDPassword: $taxDeclaration.mtdpassword, lastnumber: self.lastnumber, isupload: $isupload)
                        .tag(0)
                    
                    AgencyServiceInformationView_Company(CompanyRegistrationLocation: $taxDeclaration.companyregistrationlocation, CompanyName: $taxDeclaration.companyname, BusinessLicenseNumber: $taxDeclaration.businesslicensenumber, CompanyEstablishmentDate: $CompanyEstablishmentDate, CompanyOperationalAddress: $taxDeclaration.companyoperationaladdress, PostalCode: $taxDeclaration.postalcode, CompanyPhoneNumber: $taxDeclaration.companyphonenumber, CompanyContactEmail: $taxDeclaration.companycontactemail, lastnumber: self.lastnumber, isupload: $isupload, VATNumber: $taxDeclaration.vatnumber)
                        .tag(1)
                    
                    AgencyServiceInformationView_Legal( LegalRepresentativeName: $taxDeclaration.legalrepresentativename, lastnumber: self.lastnumber, isupload: $isupload, VATNumber: $taxDeclaration.vatnumber)
                        .tag(2)
                    
                    AgencyServiceInformationView_Shop(MainSalesPlatform: $taxDeclaration.mainsalesplatform, ShopName: $taxDeclaration.shopname, InformationLink: $taxDeclaration.informationlink, ShopBackendSellerAddress: $taxDeclaration.shopbackendselleraddress, ShopBackendCompanyName: $taxDeclaration.shopbackendcompanyname, MainBusinessScope: $taxDeclaration.mainbusinessscope, tax: $taxDeclaration, lastnumber: self.lastnumber, isupload: $isupload, VATNumber: $taxDeclaration.vatnumber)
                        .tag(3)
                }
                .tabViewStyle(.page(indexDisplayMode: .never))
            }
        }
        .onChange(of: LastReportedDate)
        {
            newvalue in
            let dateFormatter = DateFormatter()
            dateFormatter.dateFormat = "yyyy-MM-dd"
            
            
            self.taxDeclaration.lastreporteddate = dateFormatter.string(from: LastReportedDate)
        }
        .onChange(of: TaxNumberEffectiveDate)
        {
            newvalue in
            let dateFormatter = DateFormatter()
            dateFormatter.dateFormat = "yyyy-MM-dd"
            self.taxDeclaration.taxnumbereffectivedate = dateFormatter.string(from: TaxNumberEffectiveDate)
        }
        .onChange(of: CompanyEstablishmentDate)
        {
            newvalue in
            let dateFormatter = DateFormatter()
            dateFormatter.dateFormat = "yyyy-MM-dd"
            self.taxDeclaration.companyestablishmentdate = dateFormatter.string(from: CompanyEstablishmentDate)
            
        }
        .onChange(of: LastDeclarationDate)
        {
            newvalue in
            let dateFormatter = DateFormatter()
            dateFormatter.dateFormat = "yyyy-MM-dd"
            self.taxDeclaration.lastdeclarationdate = dateFormatter.string(from: LastDeclarationDate)
        }
        .onAppear{
            let dateFormatter = DateFormatter()
            dateFormatter.dateFormat = "yyyy-MM-dd"
            self.taxDeclaration.lastdeclarationdate = dateFormatter.string(from: LastDeclarationDate)
            self.taxDeclaration.companyestablishmentdate = dateFormatter.string(from: CompanyEstablishmentDate)
            self.taxDeclaration.taxnumbereffectivedate = dateFormatter.string(from: TaxNumberEffectiveDate)
            self.taxDeclaration.lastreporteddate = dateFormatter.string(from: LastReportedDate)
            
            let prodiver = MoyaProvider<TaxdeclarationRequestAPI>()
            
            prodiver.request(.pageList(pageSize: 1, pageNum: 1)) { result in
                switch result
                {
                case .success(let req):
                    do
                    {
                        let jsondata = req.data
                        let data = try JSONDecoder().decode(TaxdeclarationRequest.self, from: jsondata)
                        self.lastnumber = data.data.records[data.data.records.count - 1].declarationid + 1
                    }catch let error
                    {
                        print(error)
                    }
                    
                case .failure(_):
                    break
                }
            }
        }
        
        
        
        
//MARK: -- 大型屎山石乐志界面，看了别骂，我自己写完都想骂自己
    }
}

#Preview {
    AgencyServiceInformationView()
        .environmentObject(VATDocumentViewModel())
}
