//
//  CultivateView_Search_Finish.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/10.
//

import SwiftUI

struct CultivateView_Search_Finish: View {
    @State var seatchText : String
    var body: some View {
        ScrollView( showsIndicators: false)
        {
            VStack
            {
                if(CultivateView_Information_Datas.filter({ it in
                    it.question.contains(seatchText) || it.answer.contains(seatchText)
                }) != [CultivateView_Information_Data]()){
                    ForEach(CultivateView_Information_Datas.filter({ it in
                        it.question.contains(seatchText) || it.answer.contains(seatchText)
                    }) , id: \.self)
                    {
                        it in
                        CultivateView_Information_One(question: it.question, answer: it.answer)
                    }
                }
                else
                {
                    Text("无搜索信息内容,请切换搜索的内容")
                        .font(.system(size: 25))
                        .fontWeight(.heavy)
                        .foregroundStyle(.gray)
                        .offset(y : 200)
                }
            }
        }
        .navigationTitle(" \(self.seatchText) 查询结果")
    }
}

#Preview {
    CultivateView_Search_Finish(seatchText: "")
}
