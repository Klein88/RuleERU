//
//  PrivacyView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/22.
//

import SwiftUI

struct PrivacyView: View {
    @State var isToDetermineAdminstertView : Bool = false
    @State var isToComplianceAndSafetyInspectionView : Bool = false
    @State var isToLawSearchView : Bool = false
    @State var isshowmessage : Bool = false
    var body: some View {
            ScrollView(showsIndicators: false){
                        VStack{
                            Image(.GDPR)
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: UIScreen.main.bounds.width)
                                .cornerRadius(40)
                            
                            ZStack{
                                Color.blue
                                HStack
                                {
                                    Image(.什么是GDPR)
                                    Text("什么是GDPR?  >")
                                        .foregroundStyle(.blue)
                                        .font(.system(size : 25))
                                        .fontWeight(.heavy)
                                        
                                }
                                .frame(width: UIScreen.main.bounds.width - 20 , height: 70)
                                .background(.white)
                                .cornerRadius(20)
                            }
                            .frame(width: UIScreen.main.bounds.width - 10 , height: 80)
                            .cornerRadius(20)
                            .onTapGesture {
                                self.isshowmessage = true
                            }
                            .padding(.top , 20)

                            
                            ZStack{
                                Color.blue
                                ZStack
                                {
                                    Image(.GDPR_2)
                                        .resizable()
                                        .aspectRatio(contentMode: .fill)
                                        .frame(width: UIScreen.main.bounds.width  / 2 - 10)
                                        .opacity(0.4)
                                    Button(action: {
                                        self.isToDetermineAdminstertView = true
                                    }, label: {
                                        Text("数据隐私和保护评估")
                                            .foregroundStyle(.blue)
                                            .font(.system(size : 25))
                                            .fontWeight(.heavy)
                                            .frame(width: UIScreen.main.bounds.width  / 3)
                                        NavigationLink(destination:DetermineAdministertView() , isActive: $isToDetermineAdminstertView,label: {EmptyView()})
                                    })
                                        
                                }
                                .frame(width: UIScreen.main.bounds.width  / 2 - 10 , height: UIScreen.main.bounds.width  / 2 - 10)
                                .background(.white)
                                .cornerRadius(20)
                            }
                            .frame(width: UIScreen.main.bounds.width  / 2 , height: UIScreen.main.bounds.width  / 2)
                            .cornerRadius(20)
                            .onTapGesture {
                                self.isshowmessage = true
                            }
                            .padding(.top , 20)

                            
                            
                           
                            
                            
                            
                        }
                    }
                    .slideOverCard(isPresented: $isshowmessage) {
                        ScrollView( showsIndicators: false){
                            VStack
                            {
                                Image(.GDPR)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width / 2)
                                    .cornerRadius(40)
                                Image(.什么是GDPR1)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width - 10)
                                Text("      欧盟发布的《通用数据保护条例》（General Data Protection Regulation，以下简称“GDPR”）被认为是史上最严格的数据保护法规，违反者将面临高达2000万欧元或全球营业额4%的罚款，并且也引领了全球数据隐私保护的从严监管趋势。")
                                    .frame(width: UIScreen.main.bounds.width - 10)
                                Text("      面对如此严厉的惩罚后果，清晰了解GDPR管辖范围对任何经营实体均至关重要。欧盟数据保护委员会（European Data Protection Board，以下简称“EDPB”)于2019年底更新了“关于GDPR第三条地域管辖权”的指引。")
                                    .frame(width: UIScreen.main.bounds.width - 10)
                                Text("      GDPR是2016年通过的旨在保护欧盟境内个人的数据隐私和安全的法律。GDPR被认为是史上最严格的数据保护法规，违反者将面临高达2000万欧元或全球营业额4%的罚款，并且也引领了全球数据隐私保护的从严监管趋势，比如中国《个人信息保护法》就规定了最高5000万元人民币或上一年度营业额5%的罚款。面对如此严厉的惩罚后果，无论是数据控制者还是数据处理者均需要清晰了解GDPR的管辖范围，才能做到有的放矢地管控数据处理活动中违反GDPR的风险。")
                                    .frame(width: UIScreen.main.bounds.width - 10)
                                Image(.什么是GDPR2)
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: UIScreen.main.bounds.width - 10)
                                    .padding()
                            }
                        }
                        .overlay(alignment: .topTrailing, content: {
                            Button(action: {
                                isshowmessage = false
                            }, label: {
                                Image(systemName: "x.circle")
                                    .padding(.trailing , 20)
                                    .padding(.top , 20)
                            })
                        })
                        .padding(.bottom , 30)
                    }
           
//                Button(action: {
//                    self.isToComplianceAndSafetyInspectionView = true
//                }, label: {
//                    Text("合规安全评估")
//                    NavigationLink(destination: ComplianceAndSafetyInspectionView() ,isActive: $isToComplianceAndSafetyInspectionView, label: {EmptyView()})
//                })
//                
//                Button(action: {
//                    self.isToLawSearchView = true
//                }, label: {
//                    Text("隐私法规查询")
//                    NavigationLink(destination: LawSearchView(), isActive: $isToLawSearchView,label: {EmptyView()})
//                })
            
    }
}


#Preview {
    PrivacyView()
}
