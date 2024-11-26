//
//  DetermineAdministert.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/22.
//

import SwiftUI

struct DetermineAdministertView: View {
    @State var isToDetermineAdministertView_level_2_yes : Bool = false
    @State var isToDetermineAdministertView_level_2_no : Bool = false
    var body: some View{
       
            VStack
            {
                
                Text("数据处理行为是否涉及个人隐私？")
                    .font(.system(size: 30))
                Text("根据GDPR的引述（Recital）第22条规定，营业活动（Establishment）是指通过稳定的安排所实施地有效且实际的活动。在GDPR定义下的构成稳定安排的标准十分宽泛，如非欧盟实体在欧盟境内存在一名员工或代理就可能被认定为存在有稳定安排，但同时也需要在具体案例中考量该名员工或代理的稳定程度。需要强调的是数据控制者和数据处理者在欧盟境内营业活动并不等同于其在欧盟境内存在有分公司、子公司或代表处等法律实体，这一点是在判断该条适用时经常犯的错误。")
                    .padding(.top , 20)
                
                HStack{
                    Button(action: {
                        self.isToDetermineAdministertView_level_2_yes = true
                    }, label: {
                        Text("是")
                    })
                    Button(action: {
                        self.isToDetermineAdministertView_level_2_no = true
                    }, label: {
                        Text("否")
                    })
                }
                NavigationLink(destination: DetermineAdministertView_level_2_yes(),  isActive: $isToDetermineAdministertView_level_2_yes, label: {EmptyView()})
                NavigationLink(destination: DetermineAdministertView_Result_No(),  isActive: $isToDetermineAdministertView_level_2_no, label: {EmptyView()})
                
            }
        
    }
}


//MARK: - Level_2
struct DetermineAdministertView_level_2_yes : View
{
    @State var isToDetermineAdinistertView_level_3_yes : Bool = false
    @State var isToDetermineAdinistertView_level_3_no : Bool = false
    @Environment(\.presentationMode) var presentationMode
    var body: some View{
        
            VStack{
             Text("数据控制者和数据处理这在欧盟境内是否有营业活动？")
            Text("“欧盟境内的营业活动（Establishment）”是指通过稳定的安排而实施地有效实际活动，判断是否有营业活动时无需考虑数据控制者和数据处理者是否在欧盟境内设立有法人实体或者代表处；")
                HStack{
                    Button(action: {
                        self.isToDetermineAdinistertView_level_3_yes = true
                    }, label: {
                        Text("是")
                    })
                    Button(action: {
                        self.isToDetermineAdinistertView_level_3_no = true
                    }, label: {
                        Text("否")
                    })
                }
                NavigationLink(destination: DetermineAdministertView_level_3_yes(), isActive: $isToDetermineAdinistertView_level_3_yes,label: {EmptyView()})
                
                NavigationLink(destination: DetermineAdministertView_level_3_no(), isActive: $isToDetermineAdinistertView_level_3_no,label: {EmptyView()})
                Button(action: {
                    self.presentationMode.wrappedValue.dismiss()
                }, label: {
                    Text("返回重新选择")
                        .font(.system(size: 25))
                        .foregroundColor(.white)
                        .background(.blue)
                        .fontWeight(.heavy)
                        .cornerRadius(20)
                })
            }
       
        
    }
}


//MARK: - Level_2


//MARK: - Level_3

struct DetermineAdministertView_level_3_yes : View
{
    @State var isToDetermineAdministertView_level_4_yes : Bool = false
    @State var isToDetermineAdministertView_level_4_no : Bool = false
    
    
    var body: some View{
        
            VStack{
                Text("数据处理活动是否与欧盟境内营业活动具有不可分离的联系？")
                    
                Text("“不可分的联系（Inextricably Linked)”是指数据处理活动与欧盟境内的营业活动“不可分的联系”，需要在个案中去分析，例如：欧盟境内的营业活动会给数据控制者带来收入的增长，欧盟境内的营业活动是否与数据处理行为有关联等；")
                HStack{
                    Button(action: {
                        self.isToDetermineAdministertView_level_4_yes = true
                    }, label: {
                        Text("是")
                    })
                    Button(action: {
                        self.isToDetermineAdministertView_level_4_no = true
                    }, label: {
                        Text("否")
                    })
                }
                NavigationLink(destination: DetermineAdministertView_Result_Yes(),isActive: $isToDetermineAdministertView_level_4_yes ,  label: {EmptyView()})
                
                NavigationLink(destination: DetermineAdministertView_Result_No(), isActive: $isToDetermineAdministertView_level_4_no,label: {EmptyView()})
            }
        
    }
}

struct DetermineAdministertView_level_3_no : View {
    @State var isToDetermineAdministertView_level_4_yes : Bool = false
    @State var isToDetermineAdministertView_level_4_no : Bool = false
    
    
    var body: some View {
       
            VStack{
                Text("数据活动是否针对欧盟境内主体?")
                Text("“针对欧盟境内主体(Targrting)”需要数据控制者和处理者表示出明确的意图针对欧盟境内主体提供商品和服务，如只是偶然或不小心提供的服务，不应认定为满足“针对欧盟境内主体”标准；")
                
                HStack{
                    Button(action: {
                        self.isToDetermineAdministertView_level_4_yes = true
                    }, label: {
                        Text("是")
                    })
                    Button(action: {
                        self.isToDetermineAdministertView_level_4_no = true
                    }, label: {
                        Text("否")
                    })
                }
                
                NavigationLink(destination: DetermineAdministertView_level_4_yes(),isActive: $isToDetermineAdministertView_level_4_yes ,  label: {EmptyView()})
                
                NavigationLink(destination: DetermineAdministertView_level_4_no(), isActive: $isToDetermineAdministertView_level_4_no,label: {EmptyView()})
                
                
                
            }
        
    }
}



//MARK: - Level_3




//MARK: - Level_4
struct DetermineAdministertView_level_4_yes : View {
    @State var isToDetermineAdministertView_level_4_yes : Bool = false
    @State var isToDetermineAdministertView_level_4_no : Bool = false
    var body: some View {
       
            VStack
            {
                Text("数据活动是否针对欧盟境内主体提供商品服务或监控有关?")
                Text("“监控欧盟境内主体行为”是指欧盟境内数据主体在互联网上被追踪，包括使用个人数据处理技术对数据主体进行画像，从而实现关于数据主体的决策、分析和预测数据主体的偏好等。")
                HStack{
                    Button(action: {
                        self.isToDetermineAdministertView_level_4_yes = true
                    }, label: {
                        Text("是")
                    })
                    Button(action: {
                        self.isToDetermineAdministertView_level_4_no = true
                    }, label: {
                        Text("否")
                    })
                }
                
                NavigationLink(destination: DetermineAdministertView_Result_Yes(),isActive: $isToDetermineAdministertView_level_4_yes ,  label: {EmptyView()})
                
                NavigationLink(destination: DetermineAdministertView_Result_No(), isActive: $isToDetermineAdministertView_level_4_no,label: {EmptyView()})
                
                
            }
        
    }
}

struct DetermineAdministertView_level_4_no : View {
    
    @State var isToDetermineAdministertView_level_4_yes : Bool = false
    @State var isToDetermineAdministertView_level_4_no : Bool = false
    
    var body: some View {
        
            VStack
            {
                Text("数据活动是否基于国际公法而使用欧盟成员国法律?")
                HStack{
                    Button(action: {
                        self.isToDetermineAdministertView_level_4_yes = true
                    }, label: {
                        Text("是")
                    })
                    Button(action: {
                        self.isToDetermineAdministertView_level_4_no = true
                    }, label: {
                        Text("否")
                    })
                }
                
                NavigationLink(destination: DetermineAdministertView_Result_Yes(),isActive: $isToDetermineAdministertView_level_4_yes ,  label: {EmptyView()})
                
                NavigationLink(destination: DetermineAdministertView_Result_No(), isActive: $isToDetermineAdministertView_level_4_no,label: {EmptyView()})
            }
        
    }
}



//MARK: - Level_4



//MARK: - Result
struct DetermineAdministertView_Result_No : View {
    @Environment(\.presentationMode) var presentationMode
    var body: some View {
        VStack
        {
            Text("显示结果: 不落入GDPR第三条地域管辖")
            Button(action: {
                self.presentationMode.wrappedValue.dismiss()
            }, label: {
                Text("返回重新选择")
                    .font(.system(size: 25))
                    .foregroundColor(.white)
                    .background(.blue)
                    .fontWeight(.heavy)
                    .cornerRadius(20)
            })
        }
        .navigationBarBackButtonHidden()
    }
}


struct DetermineAdministertView_Result_Yes : View {
    @Environment(\.presentationMode) var presentationMode
    var body: some View {
        VStack
        {
            Text("显示结果: 落入GDPR管辖")
            Button(action: {
                self.presentationMode.wrappedValue.dismiss()
            }, label: {
                Text("返回重新选择")
                    .font(.system(size: 25))
                    .foregroundColor(.white)
                    .background(.blue)
                    .fontWeight(.heavy)
                    .cornerRadius(20)
            })
        }
        .navigationBarBackButtonHidden()
    }
}



//MARK: - Result







#Preview {
    DetermineAdministertView()
}
