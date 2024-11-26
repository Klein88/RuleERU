//
//  CultivateView_Introduction.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/7.
//

import SwiftUI

struct CultivateView_Introduction: View {

    
    
    
    @ViewBuilder
    private func someTextView() -> some View
    {
        VStack
        {
            HStack{
                Text("不注册VAT的影响")
                    .font(.system(size: 30))
                    .foregroundStyle(.black)
                    .fontWeight(.heavy)
                    
                Spacer()
            }
            Text("根据欧盟增值税指令2006/112 / EC和亚马逊官方公告，对于未注册、未申报、未缴纳VAT的违法行为，做出以下处罚：")
        }
    }
    
    
    var body: some View {
        NavigationView{
            VStack
            {
                Form
                {
                    Section {
                     
                            VStack
                            {
                                HStack{
                                    Image(.什么是VATIntroduction)
                                        .resizable()
                                        .aspectRatio(contentMode: .fit)
                                        .frame(width: 150)
                                        .padding(.leading , 20)
                                    Spacer()
                                }
                                Text("      VAT即增值税，是欧盟国家普遍采用的对纳税人生产经营活动的增值额征收的一种流转税。欧洲VAT由注册了VAT的卖家根据欧洲境内的销售向消费者征收，并向相关欧洲国家的税局进行申报和缴纳。")
                                    .fontWeight(.heavy)
                            }
                    }
                    Section(header: someTextView()){
                       VStack
                        {
                            HStack
                            {
                                Image(.vat处罚1)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width / 2 - 50)
                                    .shadow(radius: 10 , x : 5 , y : 5)
                                Image(.vat处罚2)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width / 2 - 50)
                                    .shadow(radius: 10 , x : 5 , y : 5)
                            }
                            HStack
                            {
                                Image(.vat处罚3)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width / 2 - 50)
                                    .shadow(radius: 10 , x : 5 , y : 5)
                                Image(.vat处罚4)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width / 2 - 50)
                                    .shadow(radius: 10 , x : 5 , y : 5)
                            }
                        }
                    }
                
                }
                .navigationTitle("什么是VAT？")
            }
        }
        
    }
}

#Preview {
    CultivateView_Introduction()
}
