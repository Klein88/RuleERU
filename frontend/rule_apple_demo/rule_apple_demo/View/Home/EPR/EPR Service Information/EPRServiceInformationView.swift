//
//  EPRServiceInformationView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/29.
//

import SwiftUI
import Moya
struct EPRServiceInformationView: View {
    @State var EPRdeclaration  : EprdeclarationRequest_1record = EprdeclarationRequest_1record(companyregistrationlocation: "", companyname: "", businesslicensenumber: "", companyestablishmentdate: "2023-10-23", companyoperationaladdress: "", postalcode: "", companyphonenumber: "", companycontactemail: "", legalrepresentativename: "", mainsalesplatform: "", shopname: "", informationlink: "", shopbackendselleraddress: "", shopbackendcompanyname: "", mainbusinessscope: "", brandcount: 0, brandenglishname: "", companyregistrationproof: Data(), idcardfront: Data(), idcardback: Data(), signature: Data() , registrationnumber: "")
    @State var lastnumber : Int = 0
    @State var isupload : Bool = false
    @State var selection : Int = 0
    @State var CompanyEstablishmentDate = Date()
    var body: some View {
        NavigationView
        {
            VStack
            {
                TabView(selection: $selection) {
                    EPRServiceInformationView_Company(EPRDeclaration: $EPRdeclaration, CompanyEstablishmentDate: $CompanyEstablishmentDate , isupload : $isupload , lastnumber : self.lastnumber)
                        .tag(0)
                    EPRServiceInformationView_Legal(EPRDeclaration: $EPRdeclaration , isupload : $isupload , lastnumber : self.lastnumber)
                        .tag(1)
                    EPRServiceInformationView_Shop(EPRDeclaration: $EPRdeclaration , isupload : $isupload , lastnumber : self.lastnumber)
                        .tag(2)
                }
                .tabViewStyle(.page(indexDisplayMode: .never))
                
                
            }

        }
        .onChange(of: self.CompanyEstablishmentDate) {
            newValue in
            let dateFormatter = DateFormatter()
            dateFormatter.dateFormat = "yyyy-MM-dd"
            self.EPRdeclaration.companyestablishmentdate = dateFormatter.string(from: self.CompanyEstablishmentDate)
        }
        .onAppear{
            let prodiver = MoyaProvider<EprdeclarationRequest_1API>()
            prodiver.request(.pageList(pageSize: 1, pageNum: 1)) { result in
                switch result
                {
                case .success(let req):
                    do
                    {
                        let jsondata = req.data
                        let data = try JSONDecoder().decode(EprdeclarationRequest_1.self, from: jsondata)
                        
                        
                        self.lastnumber = data.data.records[data.data.records.count - 1].eprdeclarationid + 1
                    }catch let error
                    {
                        print(error)
                    }
                    
                case .failure(_):
                    break
                }
            }
            
            
            
            
            
        }
    }
}

#Preview {
    EPRServiceInformationView()
        .environmentObject(EPRDocumentViewModel())
}
