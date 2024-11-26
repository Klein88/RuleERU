//
//  VATDeclarationView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/19.
//

import SwiftUI
import SlideOverCard
import Moya



struct VATDeclarationView: View {
    @State var vat : VatdeclarationdetailsRequestrecord = VatdeclarationdetailsRequestrecord(vatdeclarationnumber: "", currentvatdeclarationperiod: "", vatdeclarationcycle: "", applicabletaxrate: 0.00, taxpaymentdeadline: "", salesreportuploadplatform: "")
    @State var companyname : String
    @State var declarationCountry : String = ""
    @State var VATDeclarationNumber : String = ""
    @State var CurrentVATDeclarationPeriod : Date = Date()
    @State var isshowCurrentVATDeclarationPeriod : Bool = false
    @State var VATDeclarationCycle : String = ""
    @State var ApplicableTaxRate : Double = 0.0
    @State var isSelectByOMP : Bool = false
    @State var isSelectByNotOMP : Bool = false
    @State var OMPSalesVolume : String = "0"
    @State var NotOMPSalesVolume : String  = "0"
    @State var isToVATDeclarationView_Finish : Bool = false
    @EnvironmentObject var vatDocumentViewModel : VATDocumentViewModel
    var body: some View {
        NavigationView {
            ScrollView {
                VStack
                {
                    HStack
                    {
                        Text("基础信息")
                            .font(.system(size: 25))
                            .fontWeight(.heavy)
                            .padding(.leading , 10)
                        Spacer()
                    }
                    HStack
                    {
                        Spacer()
                        Text("报税国家 :")
                            .padding(.trailing, 20)
                        Menu {
                            Button(action: {
                                self.declarationCountry = "英国"
                                self.ApplicableTaxRate = 0
                            }, label: {
                                Text("英国")
                            })//1
                            Button(action: {
                                self.declarationCountry = "法国"
                                self.ApplicableTaxRate = 0
                            }, label: {
                                Text("法国")
                            })//2
                            Button(action: {
                                self.declarationCountry = "德国"
                                self.ApplicableTaxRate = 0
                            }, label: {
                                Text("德国")
                            })//3
                            Button(action: {
                                self.declarationCountry = "意大利"
                                self.ApplicableTaxRate = 0
                            }, label: {
                                Text("意大利")
                            })//4
                            Button(action: {
                                self.declarationCountry = "西班牙"
                                self.ApplicableTaxRate = 0
                            }, label: {
                                Text("西班牙")
                            })//5
                            Button(action: {
                                self.declarationCountry = "波兰"
                                self.ApplicableTaxRate = 0
                            }, label: {
                                Text("波兰")
                            })//6
                            Button(action: {
                                self.declarationCountry = "捷克"
                                self.ApplicableTaxRate = 0
                            }, label: {
                                Text("捷克")
                            })//7
                            Button(action: {
                                self.declarationCountry = "荷兰"
                                self.ApplicableTaxRate = 0
                            }, label: {
                                Text("荷兰")
                            })//8
                            Button(action: {
                                self.declarationCountry = "奥地利"
                                self.ApplicableTaxRate = 0
                            }, label: {
                                Text("奥地利")
                            })//9
                        } label: {
                            Text("\(self.declarationCountry)")
                                .frame(width: UIScreen.main.bounds.width / 2 - 10 , height: 40)
                                .background(.white)
                        }
                        .padding(.trailing , 20)
                        
                        
                    }
                    .frame(width: UIScreen.main.bounds.width - 10 , height: 60)
                    .background(.gray.opacity(0.2))
                    .cornerRadius(5)
                    
                    HStack
                    {
                        Text("VAT信息")
                            .font(.system(size: 25))
                            .fontWeight(.heavy)
                            .padding(.leading , 10)
                        Spacer()
                    }
                    .padding(.top , 20)
                    
                    Group {
                        HStack
                        {
                            Spacer()
                            Text("申报税号 :")
                                .padding(.trailing, 20)
                            HStack(spacing : 0){
                                Text("\(ReturnDutyParagraphByCountry(country:self.declarationCountry ))")
                                    .frame(width: 40, height: 40)
                                    .background(.white)
                                    .border(.gray.opacity(0.5))
                                TextField("请输入申报税号", text: $VATDeclarationNumber)
                                    .frame(width: UIScreen.main.bounds.width / 2 - 10 , height: 40)
                                    .background(.white)
                                    .padding(.trailing , 20)
                            }
                            
                        }
                        .frame(width: UIScreen.main.bounds.width - 10 , height: 60)
                        .background(.gray.opacity(0.1))
                        .cornerRadius(5)
                        HStack
                        {
                            Spacer()
                            Text("本期VAT申报时间 :")
                                .padding(.trailing , 20)
                            Text("\(Calendar.current.component(.year, from: self.CurrentVATDeclarationPeriod))年\(Calendar.current.component(.month, from: self.CurrentVATDeclarationPeriod))月\(Calendar.current.component(.day, from: self.CurrentVATDeclarationPeriod))日")
                                .frame(width: UIScreen.main.bounds.width / 2 - 10 , height: 40)
                                .background(.white)
                                .padding(.trailing , 20)
                                .onTapGesture {
                                    self.isshowCurrentVATDeclarationPeriod = true
                                }
                            
                            
                        }
                        .frame(width: UIScreen.main.bounds.width - 10 , height: 60)
                        .background(.gray.opacity(0.1))
                        .cornerRadius(5)
                        HStack
                        {
                            Spacer()
                            Text("------")
                            Text("\(Calendar.current.component(.year, from: self.CurrentVATDeclarationPeriod))年\(GetEndOfLastReportedDate(mouth:Calendar.current.component(.month, from: self.CurrentVATDeclarationPeriod)))月31日")
                                .frame(width: UIScreen.main.bounds.width / 2 - 10 , height: 40)
                                .background(.gray.opacity(0.4))
                                .padding(.trailing , 20)
                        }
                        .frame(width: UIScreen.main.bounds.width - 10 , height: 60)
                        .background(.gray.opacity(0.1))
                        .cornerRadius(5)
                        HStack
                        {
                            Spacer()
                            Text("申报周期 :")
                                .padding(.trailing , 20)
                            Menu {
                                Button(action: {
                                    self.VATDeclarationCycle = "月度申报"
                                }, label: {
                                    Text("月度申报")
                                })
                                Button(action: {
                                    self.VATDeclarationCycle = "季度申报"
                                }, label: {
                                    Text("季度申报")
                                })
                            } label: {
                                Text("\(self.VATDeclarationCycle)")
                                    .frame(width: UIScreen.main.bounds.width / 2 - 10 , height: 40)
                                    .background(.white)
                            }
                            .padding(.trailing , 20)
                            
                        }
                        .frame(width: UIScreen.main.bounds.width - 10 , height: 60)
                        .background(.gray.opacity(0.1))
                        .cornerRadius(5)
                        HStack
                        {
                            Spacer()
                            Text("税率%")
                                .padding(.trailing , 20)
                            
                            Menu {
                                ForEach(ReturnDeclarationByCountry(country: self.declarationCountry) , id : \.self)
                                {
                                    it in
                                    Button(action: {
                                        self.ApplicableTaxRate = it
                                    }, label: {
                                        Text("\(it * 100)%")
                                    })
                                }
                            } label: {
                                Text("\(self.ApplicableTaxRate * 100)%")
                                    .frame(width: UIScreen.main.bounds.width / 2 - 10 , height: 40)
                                    .background(.white)
                            }
                            .padding(.trailing , 20)
                            
                            
                        }
                        .frame(width: UIScreen.main.bounds.width - 10 , height: 60)
                        .background(.gray.opacity(0.1))
                        .cornerRadius(5)
                    }
                    //MARK: ----上传销售数据
                    //MARK: ---------Group
                    Group
                    {
                        if declarationCountry != ""{
                            HStack
                            {
                                Text("上传销售报告")
                                    .padding(.leading , 10)
                                Spacer()
                            }
                            .padding(.top , 20)
                            HStack
                            {
                                Text("OMP平台")
                                    .frame(width: UIScreen.main.bounds.width  / 2 - 10, height: 100)
                                    .foregroundStyle(isSelectByOMP ? .blue : .black)
                                    .border(isSelectByOMP ? .blue : .black)
                                    .onTapGesture{
                                        self.isSelectByOMP.toggle()
                                    }
                                Text("非OMP平台")
                                    .frame(width: UIScreen.main.bounds.width  / 2 - 10, height: 100)
                                    .foregroundStyle(isSelectByNotOMP ? .blue : .black)
                                    .border(isSelectByNotOMP ? .blue : .black)
                                    .onTapGesture{
                                        self.isSelectByNotOMP.toggle()
                                    }
                            }
                        }
                        
                        
                        
                        //MARK: --------OMP
                        if self.isSelectByOMP
                        {
                            HStack
                            {
                                Text("OMP平台含税销售额")
                                    .padding(.leading , 10)
                                Spacer()
                            }
                            HStack(spacing : 0)
                            {
                                //part1 AnalyzeOMP
                                VStack
                                {
                                    Spacer()
                                    Text("OMP平台含税销售额")
                                    Text("（如：ebay 等其他代扣代缴平台）")
                                        .font(.system(size : 15))
                                        .fontWeight(.heavy)
                                        .foregroundStyle(.red)
                                    Spacer()
                                }
                                .frame(width: UIScreen.main.bounds.width - 260, height: 150)
                                .background(.gray.opacity(0.1))
                                //part2
                                VStack
                                {
                                        VStack{
                                            Text("请填写OMP平台含税销售额")
                                            Text("\(Calendar.current.component(.year, from: self.CurrentVATDeclarationPeriod))年\(Calendar.current.component(.month, from: self.CurrentVATDeclarationPeriod))月\(Calendar.current.component(.day, from: self.CurrentVATDeclarationPeriod))日")
                                            Text("--")
                                            Text("\(Calendar.current.component(.year, from: self.CurrentVATDeclarationPeriod))年\(GetEndOfLastReportedDate(mouth:Calendar.current.component(.month, from: self.CurrentVATDeclarationPeriod)))月31日")
                                        }
                                        
                                        HStack{
                                            Spacer()
                                            TextField("请输入金额", text: $OMPSalesVolume)
                                                .frame(width: 100)
                                            Spacer()
                                        }
                                        .background(.gray.opacity(0.1))
                                }
                                .frame(width: 240, height: 150)
                                .border(.gray.opacity(0.3))
                                .padding(.trailing , 10)
                            }
                        }
                        //MARK: --------NotOMP
                        if self.isSelectByNotOMP
                        {
                            HStack
                            {
                                Text("非OMP平台含税销售额")
                                    .padding(.leading , 10)
                                Spacer()
                            }
                            HStack(spacing : 0)
                            {
                                //part1
                                VStack
                                {
                                    Spacer()
                                    Text("非OMP平台含税销售额")
                                    Text("（包括：独立站及英国本土公司主体销售额）")
                                        .font(.system(size : 15))
                                        .fontWeight(.heavy)
                                        .foregroundStyle(.red)
                                    Spacer()
                                }
                                .frame(width: UIScreen.main.bounds.width - 260, height: 150)
                                .background(.gray.opacity(0.1))
                                .padding(.leading  , 10)
                                //part2
                                VStack
                                {
                                    VStack{
                                        Text("请填写非OMP平台含税销售额")
                                        Text("\(Calendar.current.component(.year, from: self.CurrentVATDeclarationPeriod))年\(Calendar.current.component(.month, from: self.CurrentVATDeclarationPeriod))月\(Calendar.current.component(.day, from: self.CurrentVATDeclarationPeriod))日")
                                        Text("--")
                                        Text("\(Calendar.current.component(.year, from: self.CurrentVATDeclarationPeriod))年\(GetEndOfLastReportedDate(mouth:Calendar.current.component(.month, from: self.CurrentVATDeclarationPeriod)))月31日")
                                    }
                                    
                                    HStack{
                                        Spacer()
                                        TextField("请输入金额", text: $NotOMPSalesVolume)
                                            .frame(width: 100)
                                        Spacer()
                                    }
                                    .background(.gray.opacity(0.1))
                                }
                                .frame(width: 240, height: 150)
                                .border(.gray.opacity(0.3))
                                .padding(.trailing , 10)
                            }
                        }
                    }
                    
                    Button(action: {
                        let dateFormatter = DateFormatter()
                        dateFormatter.dateFormat = "yyyy-MM-dd"
                        
                        self.vat = VatdeclarationdetailsRequestrecord( vatdeclarationnumber: self.VATDeclarationNumber, currentvatdeclarationperiod: dateFormatter.string(from: self.CurrentVATDeclarationPeriod), vatdeclarationcycle: self.VATDeclarationCycle, applicabletaxrate: self.ApplicableTaxRate, taxpaymentdeadline: "", salesreportuploadplatform: "")
                        
                        
                        
                        
                        let TaxPayment = TaxpaymentRequestrecord( companyname: self.companyname, country: self.declarationCountry, vatnumber: ReturnDutyParagraphByCountry(country:self.declarationCountry ) + self.VATDeclarationNumber, declarationtype: self.VATDeclarationCycle, amountdue: Double(self.OMPSalesVolume)! + Double(self.NotOMPSalesVolume)!, currency: CountryToCurrency(Country: self.declarationCountry), declarationcycle: self.VATDeclarationCycle, declarationperiod: errorDateStringToTrueString(errorDate: dateFormatter.string(from:self.CurrentVATDeclarationPeriod )), duedate: errorDateStringToTrueString(errorDate: dateFormatter.string(from:self.CurrentVATDeclarationPeriod )), paymentstatus: 1)
                        
                        
                        let prodiver = MoyaProvider<TaxpaymentRequestAPI>()
                        let prodiver2 = MoyaProvider<VatdeclarationdetailsRequestAPI>()
                        
                        prodiver.request(.add(taxpaymentrequestrecord: TaxPayment)){
                            result in
                            switch result
                            {
                            case .success(let req) :
                                do
                                {
                                    
                                }catch let error
                                {
                                    print(error)
                                }
                                
                            case .failure(_):
                                break
                        
                            }
                        }
                        
                        prodiver2.request(.add(vatdeclarationdetailsrequestrecord: self.vat)){
                            result in
                            
                            switch result
                            {
                            case .success(let req) :
                                do
                                {
                                    
                                }catch let error
                                {
                                    print(error)
                                }
                                
                            case .failure(_):
                                break
                        
                            }
                            
                            
                        }
                        
                        let prodiverTaxservice = MoyaProvider<TaxServiceRequestAPI>()
                        
                        prodiverTaxservice.request(.pageList(pageSize: 1, pageNum: 1))
                        {
                            result in
                            switch result
                            {
                            case .success(let req):
                                do
                                {
                                  
                                    let jsondata = req.data
                                    let data = try JSONDecoder().decode(TaxServiceRequest.self, from: jsondata)
                                    
                                    
                                
                                    
                                }catch let error
                                {
                                    print(error)
                                }
                                
                            case .failure(_):
                                break
                                
                            }
                        }
                        
                        
                        
                        
                        self.isToVATDeclarationView_Finish = true

                    }, label: {
                        
                        Text("开始算税")
                            .font(.system(size: 20))
                            .fontWeight(.heavy)
                            .foregroundColor(.white)
                            .frame(width: 150, height: 50)
                            .background(.blue)
                            .cornerRadius(20)
                        NavigationLink(destination: VATDclarationView_Finish(),isActive: $isToVATDeclarationView_Finish, label: {EmptyView()})
                        
                    })
                    .padding(.top , 20)
                    
                }
            }
        }
        .slideOverCard(isPresented: $isshowCurrentVATDeclarationPeriod) {
            DatePicker("本期VAT申报时间", selection: $CurrentVATDeclarationPeriod , displayedComponents: .date)
                .datePickerStyle(.graphical)
        }
    }
    
    
    private func CountryToCurrency(Country : String) -> String
    {
        switch Country
        {
        case "英国":
            return "GBP"
        default :
            return "EUR"
        }
    }
}
//MARK: --屎山代码2号
#Preview {
    VATDeclarationView( companyname: "欧税通有限公司")
        .environmentObject(VATDocumentViewModel())
}
