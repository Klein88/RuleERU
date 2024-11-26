//
//  CultivateView_Introduction_Product.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/7.
//

import SwiftUI

struct CultivateView_Introduction_Product: View {
    var body: some View {
        NavigationView{
            VStack
            {
                Form{
                    Section
                    {
                        VStack
                        {
                            Image(.什么是产品合规)
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: 150)
                            Text("         产品合规是指制造商/销售商将商品销往境外时，需要履行销售目的国相关指令和法律的要求，使其产品符合 销售目的国的法律规定，包括但不限于指定授权代表（如欧代/英代/美代），完成检测认证（如欧盟的CE认 证，英国的UKCA认证，美国的FCC/FDA/CPC以及化妆品类的CPNP/SCPN），进行ERP能效检测与注册等。")
                        }
                    }
                    .navigationTitle("什么是产品合规？")
                    Section(header: Text("产品不合规的影响").font(.system(size : 30)).fontWeight(.heavy).foregroundStyle(.black)) {
                        VStack
                        {
                            HStack
                            {
                                Image(.productPart11)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width / 2 - 50)
                                    .shadow(radius: 10 , x : 5 , y : 5)
                                Image(.productPart12)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width / 2 - 50)
                                    .shadow(radius: 10 , x : 5 , y : 5)
                            }
                            HStack
                            {
                                Image(.productPart13)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width / 2 - 50)
                                    .shadow(radius: 10 , x : 5 , y : 5)
                                
                                Image(.productPart14)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width / 2 - 50)
                                    .shadow(radius: 10 , x : 5 , y : 5)
                            }
                        }
                    }
                    
                    
                    
                    Section(header: VStack{
                        Text("谁需要注册欧代/英代？")
                            .font(.system(size: 20))
                            .fontWeight(.heavy)
                            .foregroundStyle(.black)
                        Text("同时满足以下条件的卖家，需要欧代/英代")
                        
                    }) {
                        HStack
                        {
                            Image(.productPart21)
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: UIScreen.main.bounds.width / 3 - 20)
                            
                            Image(.productPart22)
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: UIScreen.main.bounds.width / 3 - 20)
                            
                            Image(.productPart23)
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: UIScreen.main.bounds.width / 3 - 20)
                            
                        }
                    }
                    
                    
                    Section(header: VStack{
                        Text("哪些产品需要欧代/英代？")
                            .font(.system(size: 20))
                            .fontWeight(.heavy)
                            .foregroundStyle(.black)
                        Text("带有CE或UKCA标志的产品")
                    }) {
                        HStack
                        {
                            Image("Product_Part_3_1")
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: UIScreen.main.bounds.width / 2 - 50)
                            Image("Product_Part_3_2")
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: UIScreen.main.bounds.width / 2 - 50)
                        }
                    }
                    
                    
                    Section(header: VStack{
                        Text("哪些产品需要办理能效标签？")
                            .font(.system(size: 20))
                            .fontWeight(.heavy)
                            .foregroundStyle(.black)
                        Text("只要在生产或贸易过程中把“能源相关产品”投放到欧盟市场，都必须进行欧盟能源标签产品注册 。")
                        
                        
                    }) {
                       VStack
                        {
                            HStack
                            {
                                Image(.productPart41)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width / 3 - 20)
                                Image(.productPart42)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width / 3 - 20)
                                Image(.productPart43)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width / 3 - 20)
                            }
                            HStack
                            {
                                Image(.productPart44)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width / 3 - 20)
                                Image(.productPart45)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width / 3 - 20)
                                Image(.productPart46)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width / 3 - 20)
                            }
                            Text("例如：灯具和灯泡，洗衣机和洗烘一体机、洗碗机、电子显示器和冰箱等")
                                .foregroundStyle(.red)
                                .fontWeight(.bold)
                        }
                    }
                    
                    
                    Section(header: Text("如何应用欧代/英代？").font(.system(size : 20)).fontWeight(.heavy).foregroundStyle(.black)) {
                        VStack
                        {
                            Image(.productPart51)
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: UIScreen.main.bounds.width - 50)
                            Image(.productPart52)
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: UIScreen.main.bounds.width - 50)
                        }
                    }
                    
                    
                    
                }
                
            }
        }
    }
}

#Preview {
    CultivateView_Introduction_Product()
}
