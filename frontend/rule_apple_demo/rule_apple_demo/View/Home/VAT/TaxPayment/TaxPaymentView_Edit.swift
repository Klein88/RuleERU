//
//  TaxPaymentView_Edit.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/2.
//

import SwiftUI
import Moya
struct TaxPaymentView_Edit: View {
    @State var TaxPayment : TaxpaymentRequestrecord
    @Environment(\.presentationMode) var pre
    
    @State var amountdueText : String = "0"
    @State var account : String = ""
    @State var paymentcompany : String = ""
    var body: some View {
        NavigationView{
            
                VStack
                {
                    Form{
                        Section{
                            Company($TaxPayment.companyname)
                        }
                        .navigationTitle("付款公司")
                        Section{
                            Payment($TaxPayment)
                        }
                    }
                }
            
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
    
    private func EnglishCurrencyToChineseCurrency(Currency  : String) -> String
    {
        switch Currency
        {
        case "GBP":
            return "英镑"
        default :
            return "欧元"
        }
    }
    
    @ViewBuilder
    private func Company(_ companyname : Binding<String>) -> some View{
        VStack
        {
            
//            HStack
//            {
//                Text("付款公司")
//                    .font(.system(size: 30))
//                    .fontWeight(.heavy)
//                    .padding(.leading , 20)
//                Spacer()
//            }
            ZStack
            {
                Color.blue
                TextField("请输入付款公司", text: $TaxPayment.companyname)
                    .frame(width: UIScreen.main.bounds.width - 110 , height: 40)
                    .background(.white)
                    .cornerRadius(10)
                    
            }
            .frame(width: UIScreen.main.bounds.width - 100 , height: 50).cornerRadius(15)
        }
    }
    
    
    
    
    
    @ViewBuilder
    private func Payment(_ TaxPayment : Binding<TaxpaymentRequestrecord>) -> some View
    {
        
        VStack
        {
            HStack
            {
                Text("缴税信息")
                    .font(.system(size: 30))
                    .fontWeight(.heavy)
                    .padding(.leading , 20)
                Spacer()
            }
            HStack{
                Text("待缴税总计")
                    .padding(.leading , 40)
                TextField("", value: $TaxPayment.amountdue, formatter: NumberFormatter())
                    .modifier(TextFieldViewModifier(width: 100))
                Text("\(CountryToCurrency(Country: TaxPayment.country.wrappedValue))")
                Text("(\(EnglishCurrencyToChineseCurrency(Currency:CountryToCurrency(Country: TaxPayment.country.wrappedValue))))")
                Spacer()
            }
            HStack
            {
                Text("税号")
                    .font(.system(size: 25))
                    .fontWeight(.heavy)
                    .padding(.leading , 40)
                TextField("请输入税号" , text: $TaxPayment.vatnumber)
                    .modifier(TextFieldViewModifier(width: 100))
                Spacer()
                    
            }
            
            HStack(spacing: 0)
            {
                VStack(spacing: 0){
                    Text("申报期间")
                        .frame(width: 150 , height: 60)
                        .border(.black ,width: 2)
                    TextField("申报期间", text: $TaxPayment.declarationtype)
                        .modifier(TextFieldViewModifier(width: 100))
                        .frame(width: 150 , height: 60)
                        .border(.black ,width: 2)
                }
                VStack(spacing: 0){
                    Text("税金")
                        .frame(width: 150 , height: 60)
                        .border(.black ,width: 2)
                    Text("\(TaxPayment.amountdue.wrappedValue - (TaxPayment.amountdue.wrappedValue / (ReturnDeclarationByCountry(country : "英国")[3] + 1)) )")
                        .frame(width: 150 , height: 60)
                        .border(.black ,width: 2)
                }
            }
            Group{
                HStack
                {
                    Text("付款信息")
                        .font(.system(size: 30))
                        .fontWeight(.heavy)
                        .padding(.leading , 20)
                    Spacer()
                }
                HStack
                {
                    Spacer()
                    VStack
                    {
                        Text("收款客户")
                            .font(.system(size: 25))
                            .fontWeight(.heavy)
                        TextField("收款客户", text: $account)
                            .modifier(TextFieldViewModifier(width: 100))
                        
                    }
                    Spacer()
                    VStack
                    {
                        Text("收款公司")
                            .font(.system(size: 25))
                            .fontWeight(.heavy)
                        TextField("收款公司", text: $paymentcompany)
                            .modifier(TextFieldViewModifier(width: 100))
                    }
                    Spacer()
                }
            }
            
            HStack{
                Spacer()
                Button(action: {
                    TaxPayment.paymentstatus.wrappedValue = 2
                    TaxPayment.currency.wrappedValue = CountryToCurrency(Country: TaxPayment.country.wrappedValue)
                 //   TaxPayment.amountdue.wrappedValue = Double(amountdueText)
                    print("TaxPayment.amountdue.wrappedValue" , TaxPayment.amountdue.wrappedValue)
                   let prodiver = MoyaProvider<TaxpaymentRequestAPI>()
                    prodiver.request(.update(taxpaymentrequestrecord: TaxPayment.wrappedValue)) { result in
                        switch result
                        {
                        case .success(_):
                            do
                            {
                                pre.wrappedValue.dismiss()
                            }catch let error
                            {
                                print(error)
                            }
                        case .failure(_):
                            break
                        }
                    }
                    
                    
                    
                    let dateFormatter = DateFormatter()
                    dateFormatter.dateFormat = "yyyy-MM-dd"
                    
                    
                    let prodiverByRefund = MoyaProvider<TaxrefundRequestAPI>()
                    let taxrefundrequestrecord  = TaxrefundRequestrecord( country: TaxPayment.country.wrappedValue, vatnumber: TaxPayment.vatnumber.wrappedValue, declarationtype: TaxPayment.declarationtype.wrappedValue, declarationcycle: TaxPayment.declarationtype.wrappedValue, declarationdate: dateFormatter.string(from: Date()), refundamount: TaxPayment.amountdue.wrappedValue - (TaxPayment.amountdue.wrappedValue / (ReturnDeclarationByCountry(country : "英国")[3] + 1)), operation: 1)
                    prodiverByRefund.request(.add(taxrefundrequestrecord: taxrefundrequestrecord)) { result in
                        switch result 
                        {
                        case .success(_):
                            break
                        case .failure(_):
                            break
                        }
                    }
                
                    
                }, label: {
                    Text("支付")
                        .foregroundStyle(.white)
                        .font(.system(size: 30))
                        .fontWeight(.heavy)
                        .frame(width: 100 , height: 60)
                        .background(.blue)
                        .cornerRadius(20)
                })
                .padding(.trailing , 30)
            }
            .padding(.top , 30)
            
        }
    }
    
}


#Preview {
    TaxPaymentView_Edit(TaxPayment: TaxpaymentRequestrecord( companyname: "欧税通有限公司", country: "英国", vatnumber: "GB123456", declarationtype: "季度申报", amountdue: 5000.00, currency: "EUR", declarationcycle: "Q1 2023", declarationperiod: "2023-04-15", duedate: "2023-04-15", paymentstatus: 1))
}
