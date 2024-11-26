//
//  CultivateView_Declaration.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/9.
//

import SwiftUI

struct CultivateView_Declaration: View {
    
    
    
    
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
    
       VStack
        {
            Section(header: HStack
                    {
                Text("VAT百科").font(.system(size : 30)).fontWeight(.heavy).foregroundStyle(.black)
                    .padding(.leading , 20)
                Spacer()
            }){
                HStack
                {
                    ImageNearTheTextView(text: "VAT相关知识", width: UIScreen.main.bounds.width / 2 - 10) {
                        Image(.vat相关知识)
                    }
                    ImageNearTheTextView(text: "VAT申报流程" , width: UIScreen.main.bounds.width / 2 - 10) {
                        Image(.vat申报流程)
                    }
                    
                }
            }
            NavigationLink(destination: CultivateView_Introduction(), label: {ImageNearTheTextView(text: "什么是VAT？", width: UIScreen.main.bounds.width - 20){
                Image(.什么是VAT)
            }})
            NavigationLink(destination: CultivateView_Introduction_EPR(), label: {ImageNearTheTextView(text: "什么是EPR？" ,width: UIScreen.main.bounds.width - 20) {
                Image(.什么是EPR)


            }})
            NavigationLink(destination: CultivateView_Introduction_Product(), label: {ImageNearTheTextView(text:"什么是产品合规？" , width: UIScreen.main.bounds.width - 20) {
                Image(.什么是产品合规)
            }})
            
           
        }
    }
}

#Preview {
    CultivateView_Declaration()
}
