//
//  CultivateView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/26.
//

import SwiftUI

struct CultivateView: View {
    @State var SearchText : String = ""
    
    @State var isToSearchFinishView : Bool = false

    var body: some View {
        NavigationView{
            ScrollView(showsIndicators: false){
                
                VStack{
                    ZStack{
                        HStack
                        {
                            TextField("请输入需要查询的内容", text: $SearchText)
                            Image(systemName: "magnifyingglass")
                                .foregroundColor(.blue)
                                .padding(.trailing , 20)
                                .onTapGesture {
                                    self.isToSearchFinishView = true
                                }
                                
                            NavigationLink(destination: CultivateView_Search_Finish(seatchText: self.SearchText), isActive: $isToSearchFinishView,label: {EmptyView()})
                        }
                        .frame(width: UIScreen.main.bounds.width - 30 , height: 50)
                        .background(.white)
                        .clipShape(RoundedRectangle(cornerRadius: 20))
                    }
                    .frame(width: UIScreen.main.bounds.width - 20 , height: 60)
                    .background(.blue)
                    .clipShape(RoundedRectangle(cornerRadius: 20))
                    
                    HStack
                    {
                        VStack{
                            Image(.adornPicture1)
                                .resizable()
                                .aspectRatio(contentMode: .fill)
                                .frame(width: 100 , height: 100)
                                
                            Image(.adornPicture2)
                                .resizable()
                                .aspectRatio(contentMode: .fill)
                                .frame(width: 100 , height: 100)
                                
                        }
                        VStack
                        {
                            NavigationLink(destination: CultivateView_market(), label: {
                                Text("市场")
                                    .frame(width: 100 , height: 70)
                                    .background(.blue)
                                    .foregroundColor(.white)
                                    .font(.system(size: 20))
                                    .fontWeight(.heavy)
                                    .clipShape(RoundedRectangle(cornerRadius: 20))
                            })
                            NavigationLink(destination: CultivateView_Declaration(), label: {Text("申报")
                                    .frame(width: 100 , height: 70)
                                    .background(.blue)
                                    .foregroundColor(.white)
                                    .font(.system(size: 20))
                                    .fontWeight(.heavy)
                                    .clipShape(RoundedRectangle(cornerRadius: 20))})
                            
                        }
                        VStack
                        {
                            NavigationLink(destination: CultivateView_Law()) {
                                Text("法规")
                                    .frame(width: 100 , height: 70)
                                    .background(.blue)
                                    .foregroundColor(.white)
                                    .font(.system(size: 20))
                                    .fontWeight(.heavy)
                                    .clipShape(RoundedRectangle(cornerRadius: 20))
                            }
                            
                            NavigationLink(destination: CultivateView_Other(), label: {
                                
                                Text("其他")
                                    .frame(width: 100 , height: 70)
                                    .background(.blue)
                                    .foregroundColor(.white)
                                    .font(.system(size: 20))
                                    .fontWeight(.heavy)
                                    .clipShape(RoundedRectangle(cornerRadius: 20))
                            })
                           
                           
                        }
                        VStack
                        {
                            Spacer()
                            Image(.adornPicture3)
                                .resizable()
                                .aspectRatio(contentMode: .fill)
                                .frame(width: 100 , height: 100)
                            Spacer()
                        }
                    }
                    .padding(.top , 40)
                    .padding(.bottom , 40)
                    
                    HStack
                    {
                        Text("翻译工具")
                            .font(.system(size: 35))
                            .fontWeight(.heavy)
                            .padding(.leading , 20)
                        
                        Spacer()
                        
                    }
                    BaiduTranslateView()
                    HStack
                    {
                        Text("随机推荐资料")
                            .font(.system(size: 35))
                            .fontWeight(.heavy)
                            .padding(.leading , 20)
                        
                        Spacer()
                        
                    }
                    CultivateView_Information_List()
                    
                }
                
            }
            .background(MotionAnimationView(colorName: Color.blue.opacity(0.8)))
            
        }
        .onAppear{
            
        }
        
    }
    
    
    
    @ViewBuilder
    private func ImageNearTheTextView(text : String ,width : CGFloat , imageView : () -> Image ) -> some View
    {
        ZStack
        {
            HStack{
                imageView()
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 100)
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
    
}

#Preview {
    CultivateView()
}
