//
//  CultivateView_Introduction_EPR.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/7.
//

import SwiftUI

struct CultivateView_Introduction_EPR: View {
    
    
    
    
    @ViewBuilder
    private func Part_2_View( text : String, imageView : () -> Image) -> some View
    {
        HStack
        {
            imageView()
                .resizable()
                .aspectRatio(contentMode: .fit)
                .frame(width: 100)
            Text("\(text)")
                .font(.system(size: 20))
                .fontWeight(.heavy)
                
        }
        .overlay(alignment: .bottom) {
            Text("")
                .frame(width: UIScreen.main.bounds.width - 70 , height: 4)
                .background(.blue)
        }
    }
    
    
    @ViewBuilder
    private func someTextView() -> some View
    {
        VStack
        {
            HStack{
                Text("不注册EPR的影响")
                    .font(.system(size: 30))
                    .foregroundStyle(.black)
                    .fontWeight(.heavy)
                    
                Spacer()
            }
//            Text("根据欧盟增值税指令2006/112 / EC和亚马逊官方公告，对于未注册、未申报、未缴纳VAT的违法行为，做出以下处罚：")
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
                                Text(" 生产者责任延伸（EPR）是欧盟的一项环境政策，要求生产者对其在市场上所推出商品的整个生命周期负责， 既从商品设计到商品生命周期结束（包括废物收集和处理）")
                                    .fontWeight(.heavy)
                            }
                    }
                    Section(header: someTextView()){
                       VStack
                        {
                            HStack
                            {
                                Image(.epr处罚1)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width / 2 - 50)
                                    .shadow(radius: 10 , x : 5 , y : 5)
                                Image(.epr处罚2)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width / 2 - 50)
                                    .shadow(radius: 10 , x : 5 , y : 5)
                            }
                            HStack
                            {
                                Image(.epr处罚3)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width / 2 - 50)
                                    .shadow(radius: 10 , x : 5 , y : 5)
                                Image(.epr处罚4)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width / 2 - 50)
                                    .shadow(radius: 10 , x : 5 , y : 5)
                            }
                        }
                    }
                    
                    Section(header: VStack{
                        HStack{
                            Text("谁需要注册法国/德国EPR？")
                                .font(.system(size: 25))
                                .foregroundStyle(.black)
                                .fontWeight(.heavy)
                            Spacer()
                        }
                        Text("符合以下任一条件就需要注册德国/法国EPR")
                    }){
                        Part_2_View(text: "在法国/德国市场生产符合EPR要求的商品") {
                            Image(.eprPart21)
                        }
                        Part_2_View(text: "向德国/法国市场进口符合EPR要求的商品") {
                            Image(.eprPart22)
                        }
                        Part_2_View(text: "在德国法国市场销售符合EPR要求的商品，且您并未在法国成立公司") {
                            Image(.eprPart23)
                        }
                    }
                    
                    
                    Section(header: VStack{Text("EPR涉及哪些商品类别？").font(.system(size: 30)).fontWeight(.heavy).foregroundStyle(.black)
                        Text("德国EPR三类")
                        }) {
                            HStack
                            {
                                VStack{
                                    Image(.包装)
                                        .resizable()
                                        .aspectRatio(contentMode: .fit)
                                        .frame(width: UIScreen.main.bounds.width / 3 - 20)
                                    Text("包装")
                                }
                                
                                VStack{
                                    Image(.WEEE)
                                        .resizable()
                                        .aspectRatio(contentMode: .fit)
                                        .frame(width: UIScreen.main.bounds.width / 3 - 20)
                                    Text("WEEE(电气和电子设备)")
                                }
                                .frame(height: 130)
                                
                                VStack{
                                    Image(.电池)
                                        .resizable()
                                        .aspectRatio(contentMode: .fit)
                                        .frame(width: UIScreen.main.bounds.width / 3 - 20)
                                    Text("电池")
                                }
                            }
                        }
                    Section(header: Text("法国EPR九类"), footer: Text("例如：如果您一件商品包含电池，且有包装（几乎所有商品都有包装），那您则需要注册电池法以及包装法两项EPR服务。")) {
                        VStack
                        {
                            HStack{
                                VStack{
                                    Image(.包装)
                                        .resizable()
                                        .aspectRatio(contentMode: .fit)
                                        .frame(width: UIScreen.main.bounds.width / 3 - 20)
                                    Text("包装")
                                }
                                
                                VStack{
                                    Image(.WEEE)
                                        .resizable()
                                        .aspectRatio(contentMode: .fit)
                                        .frame(width: UIScreen.main.bounds.width / 3 - 20)
                                    Text("WEEE(电气和电子设备)")
                                }
                                .frame(height: 130)
                                
                                VStack{
                                    Image(.电池)
                                        .resizable()
                                        .aspectRatio(contentMode: .fit)
                                        .frame(width: UIScreen.main.bounds.width / 3 - 20)
                                    Text("电池")
                                }
                            }
                            HStack{
                                VStack{
                                    Image(.家具)
                                        .resizable()
                                        .aspectRatio(contentMode: .fit)
                                        .frame(width: UIScreen.main.bounds.width / 3 - 20)
                                    Text("包装")
                                }
                                
                                VStack{
                                    Image(.纸)
                                        .resizable()
                                        .aspectRatio(contentMode: .fit)
                                        .frame(width: UIScreen.main.bounds.width / 3 - 20)
                                    Text("WEEE(电气和电子设备)")
                                }
                                .frame(height: 130)
                                
                                VStack{
                                    Image(.轮胎)
                                        .resizable()
                                        .aspectRatio(contentMode: .fit)
                                        .frame(width: UIScreen.main.bounds.width / 3 - 20)
                                    Text("电池")
                                }
                            }
                            HStack{
                                VStack{
                                    Image(.纺织品)
                                        .resizable()
                                        .aspectRatio(contentMode: .fit)
                                        .frame(width: UIScreen.main.bounds.width / 3 - 20)
                                    Text("包装")
                                }
                                
                                VStack{
                                    Image(.化学品)
                                        .resizable()
                                        .aspectRatio(contentMode: .fit)
                                        .frame(width: UIScreen.main.bounds.width / 3 - 20)
                                    Text("WEEE(电气和电子设备)")
                                }
                                .frame(height: 130)
                                
                                VStack{
                                    Image(.医疗设备)
                                        .resizable()
                                        .aspectRatio(contentMode: .fit)
                                        .frame(width: UIScreen.main.bounds.width / 3 - 20)
                                    Text("电池")
                                }
                            }
                        }
                    }
                    
                    
                    Section(header: Text("注册EPR之后，您还需要做什么？").font(.system(size : 25)).fontWeight(.heavy).foregroundStyle(.black)) {
                        VStack
                        {
                            Image(.eprPart31)
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: UIScreen.main.bounds.width  - 30)
                            Image(.eprPart32)
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: UIScreen.main.bounds.width  - 30)
                            Image(.eprPart33)
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: UIScreen.main.bounds.width  - 30)
                            Image(.eprPart34)
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: UIScreen.main.bounds.width  - 30)
                        }
                    }
                }
                .navigationTitle("什么是EPR？")
            }
        }
    }
}

#Preview {
    CultivateView_Introduction_EPR()
}
