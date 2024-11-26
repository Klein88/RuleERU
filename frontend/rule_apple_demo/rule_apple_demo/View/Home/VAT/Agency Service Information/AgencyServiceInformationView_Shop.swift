//
//  AgencyServiceInformationView_Shop.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/19.
//

import SwiftUI
import Moya



struct AgencyServiceInformationView_Shop: View {
    @Binding var MainSalesPlatform : String
    @State var MainSalesPlatformNum : Int = 0
    @Binding var ShopName : String
    @Binding var InformationLink : String
    @Binding var ShopBackendSellerAddress : String
    @Binding var ShopBackendCompanyName : String
    @Binding var MainBusinessScope : String
    @Binding var tax : TaxdeclarationRequestrecord
    @State var isshowloading : Bool = false
    @State var issuccess : Bool = false
    @State var lastnumber : Int
    @Binding var isupload : Bool
    @Binding var VATNumber : String
    
    @EnvironmentObject var vatdocumentViewModel  : VATDocumentViewModel
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
                            self.MainSalesPlatform = "亚马逊"
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
                            self.MainSalesPlatform = "eBay"
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
                            self.MainSalesPlatform = "其他"
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
                        TextField("请输入店铺信息名称", text: $ShopName)
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
                        
                        TextField("请输入店铺信息链接", text: $InformationLink)
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
                        
                        TextField("请输入店铺后台卖家地址", text: $ShopBackendSellerAddress)
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
                        
                        TextField("请输入店铺主要经营范围", text: $MainBusinessScope)
                            .frame(width: UIScreen.main.bounds.width - 20 , height: 40)
                            .border(.gray)
                    }
                    .padding(.top , 10)
                }
                
                Button(action: {
                    
                    
                    
                    
                    self.isshowloading = true
                    let provider = MoyaProvider<TaxdeclarationRequestAPI>()
                    self.isupload = true //Abolish
                    provider.request(.add(taxdeclarationtequestrecord: self.tax), completion: {
                        result in
                        switch result
                        {
                        case .success(let req):
                            do
                            {
                                let jsondata = req.data
                                let addreturndata = try JSONDecoder().decode(TaxdeclarationAddRequestReturn.self, from: jsondata)
                                print(addreturndata)
                                if addreturndata.code == 20000
                                {
                                    self.isshowloading = false
                                    self.issuccess = true
                                }
                                
                            }catch let error{
                                print(error)
                            }
                        case .failure(let error):
                            self.isshowloading = false
                        }
                        
                        
                    })
                    
                    let prodiverLastNumber = MoyaProvider<TaxdeclarationRequestAPI>()
                    var lastnumberNew : Int = 0
                    //MARK: -----get lastnumber For Next To Add Some message
                    
                    prodiverLastNumber.request(.pageList(pageSize: 1, pageNum: 1)){
                        result in
                        switch result
                        {
                        case .success(let req):
                            do
                            {
                                let jsondata = req.data
                                let data = try JSONDecoder().decode(TaxdeclarationRequest.self, from: req.data)
                                lastnumberNew = data.data.records[data.data.records.count - 1].declarationid + 1
                            }catch let error
                            {
                                print(error)
                            }
                        case .failure(_):
                            break
                        }
                    }
                    
                    
                    vatdocumentViewModel.TaxService.serviceprogress = "待申报"
                    let prodiverTaxservice = MoyaProvider<TaxServiceRequestAPI>()
                    prodiverTaxservice.request(.update(taxtervicetequestrecord: self.vatdocumentViewModel.TaxService))
                    {
                        result in
                        switch result
                        {
                        case .success(_):
                            break
                        case .failure(_):
                            break
                        }
                    }
                    
                    
                    
                    
                    
                    let prodiverFile = MoyaProvider<FileUploadAPI>()
                    
                    if self.vatdocumentViewModel.GongsiYingYeZhiZao != UIImage(){
                        prodiverFile.request(.upload(data: self.vatdocumentViewModel.GongsiYingYeZhiZao.jpegData(compressionQuality: 0.8)!, fileName: String(lastnumberNew) + tax.vatnumber + "公司营业执照.jpg" )){
                            result in
                        }
                        
                    }
                    
                    if self.vatdocumentViewModel.VATTaxZhengshu != UIImage(){
                        prodiverFile.request(.upload(data: self.vatdocumentViewModel.VATTaxZhengshu.jpegData(compressionQuality: 0.8)!, fileName: String(lastnumberNew) + tax.vatnumber + "VAT税号证书.jpg" )){
                            result in
                        }
                        
                    }
                    if self.vatdocumentViewModel.VATDeclaration1 != UIImage(){
                        prodiverFile.request(.upload(data: self.vatdocumentViewModel.VATDeclaration1.jpegData(compressionQuality: 0.8)!, fileName: String(lastnumberNew) + tax.vatnumber + "VAT申报1.jpg" )){
                            result in
                        }
                        
                    }
                    if self.vatdocumentViewModel.VATDeclaration2 != UIImage(){
                        prodiverFile.request(.upload(data: self.vatdocumentViewModel.VATDeclaration2.jpegData(compressionQuality: 0.8)!, fileName: String(lastnumberNew) + tax.vatnumber + "VAT申报2.jpg" )){
                            result in
                        }
                        
                    }
                    if self.vatdocumentViewModel.VATDeclaration3 != UIImage(){
                        prodiverFile.request(.upload(data: self.vatdocumentViewModel.VATDeclaration3.jpegData(compressionQuality: 0.8)!, fileName: String(lastnumberNew) + tax.vatnumber + "VAT申报3.jpg" )){
                            result in
                        }
                        
                    }
                    if self.vatdocumentViewModel.ZhaunDailiChangNuoShu != UIImage(){
                        prodiverFile.request(.upload(data: self.vatdocumentViewModel.ZhaunDailiChangNuoShu.jpegData(compressionQuality: 0.8)!, fileName: String(lastnumberNew) + tax.vatnumber + "转代理承诺书.jpg" )){
                            result in
                        }
                        
                    }

                    if self.vatdocumentViewModel.Legal_example_front != UIImage(){
                        prodiverFile.request(.upload(data: self.vatdocumentViewModel.Legal_example_front.jpegData(compressionQuality: 0.8)!, fileName: String(lastnumberNew) + tax.vatnumber + "身份证前.jpg" )){
                            result in
                        }
                        
                    }
                    
                    if self.vatdocumentViewModel.Legal_example_back != UIImage(){
                        prodiverFile.request(.upload(data: self.vatdocumentViewModel.Legal_example_back.jpegData(compressionQuality: 0.8)!, fileName: String(lastnumberNew) + tax.vatnumber + "身份证后.jpg" )){
                            result in
                        }
                        
                    }
                    
                    if self.vatdocumentViewModel.Legal_example_签字 != UIImage(){
                        prodiverFile.request(.upload(data: self.vatdocumentViewModel.Legal_example_签字.jpegData(compressionQuality: 0.8)!, fileName: String(lastnumberNew) + tax.vatnumber + "法人代表签字.jpg" )){
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

#Preview {
    AgencyServiceInformationView()
        .environmentObject(VATDocumentViewModel())
}
