//
//  TabLayoutView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/15.
//

import SwiftUI
import TabBar
enum Item: Int, Tabbable {
    case first = 0
    case second
    case third
    
    var icon: String {
        switch self {
            case .first: "house"
            case .second: "house"
            case .third: "person"
        }
    }
    
    var title: String {
        switch self {
            case .first:  "主页"
            case .second: "un"
            case .third:  "用户"
        }
    }
}


struct TabLayoutView: View {
    @State var selection : Int = 0
    
    init()
    {
        let appearance = UITabBarAppearance()
        appearance.backgroundEffect = UIBlurEffect(style: .systemChromeMaterialLight)
        UITabBar.appearance().standardAppearance = appearance
        UITabBar.appearance().scrollEdgeAppearance = appearance
    }
    
    
    
        var body: some View {
            NavigationView{
                TabView(selection: $selection) {
                    HomeView()
                    
                        .tabItem {
                            VStack{
                                Image(systemName: "house")
                                Text("主页")
                            }
                            
                        }.tag(0)
                    
                    
                    InformationView()
                        .tabItem {
                            VStack
                            {
                                Image(systemName: "pencil.and.scribble")
                                Text("数据")
                            }
                        }
                        .tag(1)
                    
                    
                    
                    
                    CultivateView()
                        .tabItem {
                            VStack
                            {
                                Image(systemName: "globe.asia.australia")
                                Text("培训")
                            }
                        }
                        .tag(2)
                    
                    
                    
                    UserView()
                        .tabItem {
                            VStack
                            {
                                Image(systemName: "person")
                                Text("用户")
                            }
                            
                        }
                        .tag(3)
                    //MARK: ---到时候再加
                    
                    
                }
                .onAppear{
                    for it in 1...10
                    {
                        randomNums.append(randomIn(min: 0, max:CultivateView_Information_Datas.count - 1 ))
                    }
                }
            }
            
            .navigationBarBackButtonHidden()
            
        }
}

struct CustomTabBarStyle: TabBarStyle {
    
    public func tabBar(with geometry: GeometryProxy, itemsContainer: @escaping () -> AnyView) -> some View {
        itemsContainer()
            .background(.yellow.opacity(0.5))
            .cornerRadius(25.0)
            .frame(height: 50.0)
            .padding(.horizontal, 64.0)
            .padding(.bottom, 16.0 + geometry.safeAreaInsets.bottom)
    }
    
}

struct CustomTabItemStyle: TabItemStyle {
    
    public func tabItem(icon: String, title: String, isSelected: Bool) -> some View {
        ZStack {
            if isSelected {
                Circle()
                    .foregroundColor(.blue)
                    .frame(width: 40.0, height: 40.0)
            }
            
            Image(systemName: icon)
                .foregroundColor(isSelected ? .white : Color(.init(red: 0, green: 0, blue: 255 / 255, alpha: 1.0)))
                .frame(width: 32.0, height: 32.0)
        }
        .padding(.vertical, 8.0)
    }
    
}

#Preview {
    TabLayoutView()
        .environmentObject(UserViewModel())
        .environmentObject(VATDocumentViewModel())
        .environmentObject(EPRDocumentViewModel())
        .environmentObject(ConsumptionViewModel())
}
