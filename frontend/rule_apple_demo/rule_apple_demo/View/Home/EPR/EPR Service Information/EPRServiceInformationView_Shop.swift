//
//  EPRServiceInformationView_Shop.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/30.
//

import SwiftUI
import Moya

struct EPRServiceInformationView_Shop: View {
    @State var MainSalesPlatformNum : Int = 0
    @State var isshowloading : Bool = false
    @State var issuccess : Bool = false
    @Binding var EPRDeclaration : EprdeclarationRequest_1record
    @Binding var isupload : Bool
    @State var lastnumber : Int
    @EnvironmentObject var eprdocumentViewModel : EPRDocumentViewModel
    
    
    
    
    
    
    var body: some View {
        ScrollView{
            VStack
            {
                HStack
                {
                    Text("店铺信息")
                        .font(.system(size: 25))
                        .fontWeight(.heavy)
                        .padding(.leading , 10)
                    Spacer()
                }
                HStack
                {
                    Text("填写店铺信息")
                        .padding(.leading , 15)
                    Spacer()
                }
                HStack
                {
                    Text("主要销售平台")
                        .padding(.leading , 10)
                    Spacer()
                }
                .padding(.top , 10)
                //MARK: -------------, top
                HStack
                {
                    Text("亚马逊")
                        .font(.system(size: 25))
                        .fontWeight(.heavy)
                        .frame(width: 100)
                        .foregroundColor(self.MainSalesPlatformNum == 0 ? .blue : .black)
                        .border(self.MainSalesPlatformNum == 0 ? .blue : .black , width: 3)
                        .padding(.leading , 20)
                        .onTapGesture {
                            self.MainSalesPlatformNum = 0
                            self.EPRDeclaration.mainsalesplatform = "亚马逊"
                        }
                    Text("eBay")
                        .font(.system(size: 25))
                        .fontWeight(.heavy)
                        .frame(width: 100)
                        .foregroundColor(self.MainSalesPlatformNum == 1 ? .blue : .black)
                        .border(self.MainSalesPlatformNum == 1 ? .blue : .black , width: 3)
                        .padding(.leading , 20)
                        .onTapGesture {
                            self.MainSalesPlatformNum = 1
                            self.EPRDeclaration.mainsalesplatform = "eBay"
                        }
                    Text("其他")
                        .font(.system(size: 25))
                        .fontWeight(.heavy)
                        .frame(width: 100)
                        .foregroundColor(self.MainSalesPlatformNum == 2 ? .blue : .black)
                        .border(self.MainSalesPlatformNum == 2 ? .blue : .black , width: 3)
                        .padding(.leading , 20)
                        .onTapGesture {
                            self.MainSalesPlatformNum = 2
                            self.EPRDeclaration.mainsalesplatform = "其他"
                        }
                }
                Group
                {
                    VStack
                    {
                        HStack
                        {
                            Text("店铺信息名称")
                                .padding(.leading , 10)
                            Spacer()
                        }
                        TextField("请输入店铺信息名称", text: $EPRDeclaration.shopname)
                            .frame(width: UIScreen.main.bounds.width - 20 , height: 40)
                            .border(.gray)
                    }
                    .padding(.top , 10)
                    VStack
                    {
                        HStack{
                            Text("店铺信息链接")
                                .padding(.leading , 10)
                            Spacer()
                        }
                        
                        TextField("请输入店铺信息链接", text: $EPRDeclaration.informationlink)
                            .frame(width: UIScreen.main.bounds.width - 20 , height: 40)
                            .border(.gray)
                    }
                    .padding(.top , 10)
                    VStack
                    {
                        HStack{
                            Text("店铺后台卖家地址")
                                .padding(.leading , 10)
                            Spacer()
                        }
                        
                        TextField("请输入店铺后台卖家地址", text: $EPRDeclaration.shopbackendselleraddress)
                            .frame(width: UIScreen.main.bounds.width - 20 , height: 40)
                            .border(.gray)
                    }
                    .padding(.top , 10)
                    VStack
                    {
                        HStack{
                            Text("店铺主要经营范围")
                                .padding(.leading , 10)
                            Spacer()
                        }
                        
                        TextField("请输入店铺主要经营范围", text: $EPRDeclaration.mainbusinessscope)
                            .frame(width: UIScreen.main.bounds.width - 20 , height: 40)
                            .border(.gray)
                    }
                    .padding(.top , 10)
                }
                
                Button(action: {
                    self.isshowloading = true
                    let provider = MoyaProvider<EprdeclarationRequest_1API>()
                    self.isupload = true
                    provider.request(.add(eprdeclarationrequest_1record: EPRDeclaration)){ result in
                        switch result
                        {
                        case .success(let req):
                            do
                            {
                                let jsondata = req.data
                                let addreturndata = try JSONDecoder().decode(EprdeclarationSuccessRequest_1.self, from: jsondata)
                                print(addreturndata)
                                if addreturndata.code == 20000
                                {
                                    self.isshowloading = false
                                    self.issuccess = true
                                }
                            }catch let error
                            {
                                print(error)
                            }
                        case.failure(_):
                            self.isshowloading = false
                        }
                        
                    }
                    
                    var lastnumberNew : Int  = 0
                    
                    self.eprdocumentViewModel.Eprservice.servicesummit = 2
                    self.eprdocumentViewModel.Eprservice.servicetype = "待申报"
                    let providerEprService = MoyaProvider<EprserviceRequestAPI>()
                    providerEprService.request(.update(eprservicerequestrecord: self.eprdocumentViewModel.Eprservice))
                    {
                        result in
                    }
                    
                    
                    let prodiverimage = MoyaProvider<FileUploadAPI>()
                   
                    
                    if eprdocumentViewModel.GongsiYingYeZhiZhao != UIImage()
                    {
                        prodiverimage.request(.upload(data: eprdocumentViewModel.GongsiYingYeZhiZhao.jpegData(compressionQuality: 0.8)!, fileName: String(lastnumberNew) + self.EPRDeclaration.registrationnumber + "公司营业执照.jpg")){
                            result in
                            
                            
                            
                            
                            
                            
                            
                        }
                    }
                    
                    
                    
                    
                    
                    
                }, label: {
                    Text("完成服务信息")
                        .font(.system(size: 30))
                        .foregroundColor(.white)
                        .fontWeight(.heavy)
                        .frame(width: 200, height: 80)
                        .background(.blue)
                        .cornerRadius(20)
                        .padding(.top , 20)
                    NavigationLink(destination: AgencyServiceInformationView_add_success(), isActive: $issuccess,label: {EmptyView()})
                })
            }
        }
        .navigationTitle("店铺信息")
        .overlay {
            if self.isshowloading{
                ProgressView("loading....")
            }
        }
    }
}

