//
//  UserView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/15.
//

import SwiftUI

struct UserView: View {
    @EnvironmentObject var userViewModel : UserViewModel
    @State var selection : Int = 0
    
    var body: some View {
        VStack
        {
            VStack{
                ZStack{
                    Circle()
                        .fill(
                            AngularGradient(
                                gradient: Gradient(colors: [.blue]),
                                center: .center,
                                startAngle: .degrees(0),
                                endAngle: .degrees(360)
                            )
                        )
                        .frame(width: 170, height: 170)
                    Image("avatar1.jpg")
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .frame(width: 160)
                        .clipShape(Circle())
                }
                Text("\(userViewModel.User_Details.username)")
                    .font(.system(size: 30))
                    .fontWeight(.heavy)
                    .foregroundStyle(.gray)
                Divider()
                    .frame(width: UIScreen.main.bounds.width - 20)
                HStack
                {
                    Spacer()
                    VStack{
                        Text("公司")
                            .font(.system(size: 25))
                            .fontWeight(.heavy)
                        Text("\(userViewModel.companyinfoAll.count)")
                    }
                    Spacer()
                    Divider()
                        .frame(height: 30)
                    Spacer()
                    VStack{
                        Text("产品")
                            .font(.system(size: 25))
                            .fontWeight(.heavy)
                        Text("5")
                    }
                    Spacer()
                    Divider()
                        .frame(height: 30)
                    Spacer()
                    VStack{
                        Text("工单")
                            .font(.system(size: 25))
                            .fontWeight(.heavy)
                        Text("2")
                    }
                    Spacer()
                }
            }
            
            Form{
                Section{
                    NavigationLink(destination: UserView_Company(), label: {
                        HStack{
                            Image(systemName: "paperclip.circle")
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: 70)
                            Spacer()
                            Text("公司管理")
                                .font(.system(size: 25))
                                .fontWeight(.heavy)
                                .foregroundStyle(.blue)
                        }
                        .frame(height: 60)
                        
                        
                    })
                    
                }
                Section{
                    NavigationLink(destination: WorkOrderView(), label: {
                        HStack{
                            Image(systemName: "folder.fill")
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: 70)
                            Spacer()
                            Text("我的工单")
                                .font(.system(size: 25))
                                .fontWeight(.heavy)
                                .foregroundStyle(.blue)
                        }
                        .frame(height: 60)
                        
                        
                    })
                }
                Section{
                    NavigationLink(destination: UserView_Information(), label: {
                        HStack{
                            Image(systemName: "list.bullet.clipboard")
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: 70)
                            Spacer()
                            Text("我的资料")
                                .font(.system(size: 25))
                                .fontWeight(.heavy)
                                .foregroundStyle(.blue)
                        }
                        .frame(height: 60)
                    })
                }
                
                Section{
                    HStack{
                        Spacer()
                        Button(action: {
                            userViewModel.islogin = false
                        }, label: {
                            Text("退出登录")
                                .font(.system(size: 25))
                                .fontWeight(.heavy)
                                .foregroundStyle(.blue)
                        })
                        Spacer()
                    }
                }
            }
           

        }
        .background(MotionAnimationView(colorName: Color.blue.opacity(0.8)))
        
    }
}

#Preview {
    
    LoginView()
        .environmentObject(UserViewModel())
        
}
