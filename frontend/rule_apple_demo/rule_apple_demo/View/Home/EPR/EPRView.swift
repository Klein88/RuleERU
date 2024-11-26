//
//  EPRView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/29.
//

import SwiftUI
import SlideOverCard
struct EPRView: View {
    @State var isshowaddEPRServiceView : Bool = false
    @State var isshowEprdeclarationView : Bool = false
    
    
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
            VStack{
                
                HStack
                {
                    Text("EPR注册号:")
                        .foregroundStyle(.black)
                        .font(.system(size: 22))
                        .fontWeight(.heavy)
                        .frame(width: UIScreen.main.bounds.width / 3 - 10 , height: 40)
                    
                    Button(action: {
                        self.isshowEprdeclarationView = true
                    }, label: {
                        Text("EPR申报")
                            .foregroundStyle(.white)
                            .font(.system(size: 22))
                            .frame(width: UIScreen.main.bounds.width / 3 - 10 , height: 40)
                            .background(.blue)
                            .cornerRadius(10)
                        NavigationLink(destination: EPRdeclarationView(),isActive:  $isshowEprdeclarationView,label: {EmptyView()})
                    })
                    .padding(.trailing , 5)
                    Button(action: {
                        
                    }, label: {
                        Text("在线缴费")
                            .foregroundStyle(.white)
                            .font(.system(size: 22))
                            .frame(width: UIScreen.main.bounds.width / 3 - 10 , height: 40)
                            .background(.blue)
                            .cornerRadius(10)
                    })
                }
                .padding(.top , 20)
                NavigationLink(destination: CultivateView_Introduction_EPR(), label: {ImageNearTheTextView(text: "什么是EPR？" ,width: UIScreen.main.bounds.width - 20) {
                    Image(.什么是EPR)


                }})
                .padding(.top , 20)
                EPRServiceView_List(isshowaddEPRServiceView: $isshowaddEPRServiceView)
            }
            .navigationBarItems(trailing: Button(action: {
                self.isshowaddEPRServiceView = true
            }, label: {
                HStack
                {
                    Image(systemName: "plus")
                    Text("添加注册号")
                }
            }))
            .navigationTitle("EPR申报")
        .slideOverCard(isPresented: $isshowaddEPRServiceView) {
            addEPRServiceView(isshowaddEPRServiceView: $isshowaddEPRServiceView)
        }
        
    }
}

#Preview {
    EPRView()
}
