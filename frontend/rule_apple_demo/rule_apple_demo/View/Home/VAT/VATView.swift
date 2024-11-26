//
//  VATView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/20.
//

import SwiftUI
import SlideOverCard



struct VATView: View {
    @State var isshowaddView : Bool = false
    @State var taxdeclarationByCompanyName : [TaxdeclarationRequestrecord] = []
    @Environment(\.presentationMode) var pre
    @State var isTodeclarationView : Bool = false
    @State var isToTaxPaymentView : Bool = false
    @State var isToRefund : Bool = false
    @ViewBuilder
    private func ImageNearTheTextView(text : String ,width : CGFloat , imageView : () -> Image ) -> some View
    {
        ZStack
        {
            HStack{
                imageView()
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 60)
                    .padding(.leading , 20)
                Spacer()
                Text("\(text)")
                    .font(.system(size: 20))
                    .fontWeight(.heavy)
                Spacer()
                
            }
            .frame(width:width - 10 , height: 90)
            .background(.white)
            .clipShape(RoundedRectangle(cornerRadius: 20))
            
        }
        .frame(width: width , height: 100)
        .background(.blue)
        .clipShape(RoundedRectangle(cornerRadius: 20))
       
    }
    
    
    var body: some View {
        NavigationView{
            VStack{
                NavigationLink(destination: CultivateView_Introduction(), label: {ImageNearTheTextView(text: "什么是VAT？", width: UIScreen.main.bounds.width - 20){
                    Image(.什么是VAT)
                }})
                
                HStack
                {
                    
                        Text("税号：")
                        .font(.system(size: 20))
                        .fontWeight(.heavy)
                        .padding(.leading , 20)
                    HStack{
                        Spacer()
                        Button(action: {
                            self.isTodeclarationView = true
                        }, label: {
                            Text("申报")
                                .foregroundColor(.white)
                                .frame(width: UIScreen.main.bounds.width / 4 - 10 , height: 30)
                                .background(.blue)
                                .cornerRadius(10)
                            NavigationLink(destination: DeclarationView(), isActive: $isTodeclarationView,label: {EmptyView()})
                        })
                        Spacer()
                        Button(action: {
                            self.isToTaxPaymentView = true
                        }, label: {
                            Text("缴税")
                                .foregroundColor(.white)
                                .frame(width: UIScreen.main.bounds.width / 4 - 10 , height: 30)
                                .background(.blue)
                                .cornerRadius(10)
                            NavigationLink(destination:TaxPaymentView(), isActive:$isToTaxPaymentView ,label: {EmptyView()})
                        })
                        .padding(.leading , 10)
                        Spacer()
                        Button(action: {
                            self.isToRefund = true
                        }, label: {
                            Text("退税")
                                .foregroundColor(.white)
                                .frame(width: UIScreen.main.bounds.width / 4 - 10 , height: 30)
                                .background(.blue)
                                .cornerRadius(10)
                            NavigationLink(destination: VATPaymentRefundView(), isActive: $isToRefund,label: {EmptyView()})
                        })
                        Spacer()
                    }
                }
                .padding(.top , 20)
                
//
//                HStack{
//                    
//                    ImageNearTheTextView(text: "VAT相关知识", width: UIScreen.main.bounds.width / 2 - 10) {
//                        Image(.vat相关知识)
//                    }
//                    ImageNearTheTextView(text: "VAT申报流程", width: UIScreen.main.bounds.width / 2 - 10) {
//                        Image(.vat申报流程)
//                    }
//                    
//                }
                
                VATView_List(isshowaddview: $isshowaddView)
            }
            .navigationBarItems(leading:
                Button(action: {
                self.pre.wrappedValue.dismiss()
                }, label: {
                    HStack{
                        Image(systemName: "arrow.left")
                        Text("返回")
                    }
                })
             , trailing: HStack{
                Button(action: {
                    
                }, label: {
                    Image(systemName: "magnifyingglass")
                })
                Button(action: {
                    self.isshowaddView = true
                }, label: {
                    Image(systemName: "plus")
                })
            })
        }
        .navigationBarBackButtonHidden()
        .slideOverCard(isPresented: $isshowaddView) {
            addVATServiceView(isshowaddView: $isshowaddView)
        }
    }
}


#Preview {
    VATView()
}
