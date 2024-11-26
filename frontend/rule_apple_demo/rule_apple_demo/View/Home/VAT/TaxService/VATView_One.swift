//
//  VATView_One.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/24.
//

import SwiftUI
import SlideOverCard
import Moya


struct VATView_One: View {
    @State var Taxservice : TaxServiceRequestrecord
    @State var isToEdit : Bool = false
    @State var Tax : TaxdeclarationRequestrecord = TaxdeclarationRequestrecord()
    @EnvironmentObject var vatDocumentViewModel : VATDocumentViewModel
    var body: some View{
        VStack{
            HStack{
                VStack{
                    Image(Taxservice.country)
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .frame(width: 40 , height:30)
                }
                .padding(.leading , 20)
                
                VStack{
                    Text("\(Taxservice.companyname)")
                        .font(.system(size: 20))
                        .fontWeight(.heavy)
                    Text("\(Taxservice.vatnumber)")
                        .font(.system(size: 13))
                }
                .padding(.leading , 30)
                Spacer()
                Button(action: {
                    self.vatDocumentViewModel.TaxService = self.Taxservice
                    let provider =  MoyaProvider<TaxdeclarationRequestAPI>()
                    
                    provider.request(.findByVATNumber(searchbyvatnumber: Taxservice.vatnumber)){ result in
                        switch result{
                        case .success(let req):
                            do
                            {
                                let jsondata = req.data
                                let data = try JSONDecoder().decode(TaxdeclarationRequestByIdRequest.self, from: jsondata)
                                print("data------" , data)
                                self.Tax = data.data
                                print(Tax)
                            }catch let error
                            {
                                print(error)
                            }
                            
                        case .failure(_): break
                        }
                    }
                    self.isToEdit = true
                }, label: {
                    Image(systemName: "square.and.pencil.circle")
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .foregroundColor(.blue)
                        .frame(width: 40)
                    NavigationLink(destination: AgencyServiceInformationView(taxDeclaration: TaxdeclarationRequestrecord(vatnumber: Taxservice.vatnumber, taxrate: 0.00, taxnumbereffectivedate: "", lastdeclarationdate: "", gatewayid: "", gatewaypassword: "", lastreporteddate: "", mtdusername: "", mtdpassword: "", companyregistrationlocation: "", companyname: "", businesslicensenumber: "", companyestablishmentdate: "", companyoperationaladdress: "", postalcode: "", companyphonenumber: "", companycontactemail: "", legalrepresentativename: "", mainsalesplatform: "", shopname: "", informationlink: "", shopbackendselleraddress: "", shopbackendcompanyname: "", mainbusinessscope: "")),isActive: $isToEdit , label: {EmptyView()})
                })
                .frame(width: 100)
            }
            Divider()
            HStack
            {
                VStack{
                    Text("服务进度")
                        .foregroundColor(.gray)
                    Text("\(Taxservice.serviceprogress)")
                }
                .padding(.trailing , 20)
                Divider()
                    .frame(height: 30)
                VStack{
                    Text("税率(%)")
                        .foregroundColor(.gray)
                    Text("\(Taxservice.taxrate)")
                }
                .padding(.leading , 20)
                .padding(.trailing , 20)
                Divider()
                    .frame(height: 30)
                VStack{
                    Text("服务类型")
                        .foregroundColor(.gray)
                    Text("\(Taxservice.servicetype)")
                }
                .padding(.leading , 20)
            }
            .frame(width: UIScreen.main.bounds.width - 20 , height: 60)
            
        }
        .onChange(of: isToEdit, perform: { value in
            let provider =  MoyaProvider<TaxdeclarationRequestAPI>()
            
            provider.request(.findByVATNumber(searchbyvatnumber: Taxservice.vatnumber)){ result in
                switch result{
                case .success(let req):
                    do
                    {
                        let jsondata = req.data
                        let data = try JSONDecoder().decode(TaxdeclarationRequestByIdRequest.self, from: jsondata)
                        print("data------" , data)
                        self.Tax = data.data
                        print(Tax)
                    }catch let error
                    {
                        print(error)
                    }
                    
                case .failure(_): break
                }
            }
        })
    }
}

func ChooseFirstOrSecond(icon : Int) -> String{
    if icon == 0
    {
        return "请填写服务资料"
    }
    else
    {
        return "修改服务资料"
    }
}



#Preview {
    VATView()
        .environmentObject(VATDocumentViewModel())
}
