//
//  CultivateView_Information_List.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/10.
//

import SwiftUI


struct CultivateView_Information_List: View {
    @State var randomList : [CultivateView_Information_Data] = [CultivateView_Information_Data]()
    
    
    private func determineTrueOrFalse(num : Int) -> Bool
    {
       
        for it in randomNums
        {
            if num == it
            {
                return true
            }
        }
        return false
    }
    
    var body: some View {
       ScrollView(showsIndicators: false)
        {
            
            VStack
            {
                ForEach(0 ..< CultivateView_Information_Datas.count , id: \.self)
                {
                    it in
                    
                    if determineTrueOrFalse(num: it)
                    {
                        CultivateView_Information_One(question: CultivateView_Information_Datas[it].question, answer: CultivateView_Information_Datas[it].answer)
                    }
                }
            }
        }
    }
}

#Preview {
    CultivateView_Information_List()
}
