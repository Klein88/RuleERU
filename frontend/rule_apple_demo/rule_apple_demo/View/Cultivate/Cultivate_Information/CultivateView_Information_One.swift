//
//  CultivateView_Information_One.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/10.
//

import SwiftUI
import TipKit


struct CultivateView_Information_One: View {
    @State var question : String
    @State var answer : String
    
    
    
    
    var body: some View {
        VStack
        {
            HStack
            {
                Text("Q")
                    .fontWeight(.heavy)
                    .foregroundStyle(.white)
                    .frame(width: 20 , height: 20)
                    .background(.blue)
                    .padding(.leading , 10)
                Text("\(question)")
                    .font(.system(size: 20))
                    .fontWeight(.heavy)
                    
                Spacer()
            }
            ScrollView{
                Text("\(answer)")
            }
                .frame(width: UIScreen.main.bounds.width - 70 , height: 70)
                .background(.white)
                
        }
        .frame(width: UIScreen.main.bounds.width - 30 , height: 150)
        .background(.gray.opacity(0.1))
        .clipShape(RoundedRectangle(cornerRadius: 10))
        
    }
}

#Preview {
    CultivateView_Information_One(question: "英国vat迟申报、迟支付罚金及风险？", answer: "自 2023 年 1 月 1 日起，VAT罚款和利息的增收规则将会有变化。新的罚款机制将基于积分规则去运作。每迟交一次申报，就会收到一个积分。一旦达到罚款阈值（分数累计达到一定值），将收到 200 英镑的罚款，且之后的每次延迟提交都会收到 200 英镑的罚金。罚款阈值将根据申报周期的变化而有所不同。")
}
