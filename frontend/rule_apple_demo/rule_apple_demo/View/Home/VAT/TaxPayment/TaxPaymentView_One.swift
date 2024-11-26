//
//  TaxPaymentView_One.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/2.
//

import SwiftUI

struct TaxPaymentView_One: View {
    @State var TaxPayment : TaxpaymentRequestrecord
    @State var isToEditView : Bool = false
    var body: some View {
        ZStack{
            Color.blue
            HStack
            {
                Image(TaxPayment.country)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 40)
                VStack
                {
                    HStack
                    {
                        Text("公司 :")
                            .font(.system(size: 26))
                            .fontWeight(.heavy)
                        
                        Text(TaxPayment.companyname)
                            .font(.system(size: 20))
                            .fontWeight(.heavy)
                    }
                    .frame(width: 270)
                    Text("税号 :\(TaxPayment.vatnumber)")
                        .font(.system(size: 15))
                    Divider()
                        .frame(width: 270)
                    HStack
                    {
                        VStack
                        {
                            Text("应缴税金")
                                .fontWeight(.heavy)
                            Text("\(TaxPayment.amountdue)\(TaxPayment.currency)")
                        }
                        Divider().frame(height: 40)
                        VStack
                        {
                            Text("申报类型")
                            Text("\(TaxPayment.declarationtype)")
                        }
                        Divider().frame(height: 40)
                        VStack
                        {
                            Text("缴税状态")
                            Text("\(TaxPayment.paymentstatus == 1 ? "未缴税" : "已缴税")")
                        }
                    }
                    
                }
                Button(action: {
                    self.isToEditView = true
                }, label: {
                    Image(systemName: "square.and.pencil")
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .frame(width: 40)
                    NavigationLink(destination: TaxPaymentView_Edit(TaxPayment: self.TaxPayment), isActive: $isToEditView,label: {EmptyView()})
                })
            }
            .frame(width: UIScreen.main.bounds.width - 10 , height: 190)
            .background(.white)
            .cornerRadius(40)
        }
        .frame(width: UIScreen.main.bounds.width , height: 200)
        .cornerRadius(40)
    }
}
