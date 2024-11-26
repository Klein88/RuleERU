//
//  Bolish.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/23.
//

import Foundation



//@State var isInvolvingPersonalData : [Bool] = [false , false] //是否涉及个人数据
//@State var isNotDetermineAdministert : Bool = false //不落入管辖
//@State var isDetermineAdministert : Bool = false //落入管辖
//@State var isOperatingActivities : [Bool] = [false , false] //是否有营业活动
//@State var isForEUTerritory : [Bool] = [false , false] // 是否针对欧盟境内活动主体
//@State var isInseparableLink : [Bool] = [false , false]
//var body: some View {
//    ScrollView{
//        VStack
//        {
//            VStack{
//                Text("数据处理行为是否涉及个人数据")
//                HStack{
//                    Button(action: {
//                        self.isInvolvingPersonalData[0].toggle()
//                        self.isInvolvingPersonalData[1] = false
//                        self.isNotDetermineAdministert = false
//                    }, label: {
//                        Text("是")
//                            .foregroundStyle(self.isInvolvingPersonalData[0] ? .blue : .black)
//                    })
//                    
//                    Button(action: {
//                        self.isInvolvingPersonalData[0] = false
//                        self.isInvolvingPersonalData[1].toggle()
//                        self.isNotDetermineAdministert.toggle()
//                    }, label: {
//                        Text("否")
//                            .foregroundStyle(self.isInvolvingPersonalData[1] ? .blue : .black)
//                    })
//                }
//            }//level_1
//            
//            if isInvolvingPersonalData[0] != isInvolvingPersonalData[1]
//            {
//                Image(systemName: "arrow.down")
//                VStack{
//                    Text("数据控制者和数据处理者在欧盟境内是否有营业活动")
//                    HStack{
//                        Button(action: {
//                            self.isOperatingActivities[0].toggle()
//                            self.isOperatingActivities[1] = false
//                        }, label: {
//                            Text("是")
//                                .foregroundStyle(self.isOperatingActivities[0] ? .blue : .black)
//                        })
//                        
//                        Button(action: {
//                            self.isOperatingActivities[0] = false
//                            self.isOperatingActivities[1].toggle()
//                        }, label: {
//                            Text("否")
//                                .foregroundStyle(self.isOperatingActivities[1] ? .blue : .black)
//                        })
//                    }
//                }
//                
//                if isOperatingActivities[0] != isOperatingActivities[1]
//                {
//                    Image(systemName: "arrow.down")
//                    
//                    if isOperatingActivities[0]
//                    {
//                        Text("数据处理活动是否与欧盟境内的活动具有不可分离的联系")
//                        
//                    }//level_3_yes
//                    
//                    if isOperatingActivities[1]
//                    {
//                        Text("数据处理活动是否针对欧盟境内主体")
//                    }//level_3_no
//                    
//                    
//                }//level_3
//                
//                
//                
//                
//                
//            }//level_2
//            
//            
//            
//            
//            
//            if isNotDetermineAdministert == true
//            {
//                Text("显示结果：不落入GDPR第三项地域管辖")
//            }//level_result_1
//            
//            
//            
//            
//        }
//    }
//    
//}




//@State var Taxservice : TaxServiceRequestrecord
//@State var isshowcord : Bool = false
//@State var isToAgencyServiceInfomationView : Bool = false
//var body: some View {
//    VStack{
//        Spacer()
//        HStack{
//            Text("公司名称 : ")
//                .foregroundColor(.white)
//                .font(.system(size: 26))
//                .fontWeight(.heavy)
//                .padding(.leading , 20)
//            Text("\(Taxservice.companyname)")
//                .foregroundColor(.white)
//                .font(.system(size: 20))
//                .fontWeight(.heavy)
//            Spacer()
//        }
//        HStack{
//            Text("VAT税号 :")
//                .foregroundColor(.white)
//                .font(.system(size: 26))
//                .fontWeight(.heavy)
//                .padding(.leading , 20)
//            Text("\(Taxservice.vatnumber)")
//                .foregroundColor(.white)
//                .font(.system(size: 20))
//                .fontWeight(.heavy)
//            Spacer()
//        }
//        HStack{
//            Text("申报国家 :")
//                .foregroundColor(.white)
//                .font(.system(size: 26))
//                .fontWeight(.heavy)
//                .padding(.leading , 20)
//            Text("\(Taxservice.country)")
//                .foregroundColor(.white)
//                .font(.system(size: 20))
//                .fontWeight(.heavy)
//            Spacer()
//        }
//        HStack{
//            Button(action: {
//                self.isshowcord = true
//            }, label: {
//                Text("点击查看更多信息")
//                    .frame(width: 80)
//                    .fontWeight(.heavy)
//                    .foregroundColor(.white)
//            })
//            .frame(width: 100 , height: 60)
//            .background(.blue.opacity(0.5))
//            .cornerRadius(10)
//            
//            Button(action: {
//                
//            }, label: {
//                Text("\(ChooseFirstOrSecond(icon:Taxservice.servicesummit))")
//                    .frame(width: 80)
//                    .fontWeight(.heavy)
//                    .foregroundColor(.white)
//               // NavigationLink(destination: , label: <#T##() -> Label#>)
//            })
//            .frame(width: 100 , height: 60)
//            .background(.blue.opacity(0.5))
//            .cornerRadius(10)
//        }
//        .padding(.bottom , 10)
//    }
//    .frame(width: UIScreen.main.bounds.width - 10 , height:  UIScreen.main.bounds.height / 4)
//    .background(LinearGradient(colors: [Color(#colorLiteral(red: 0.2588235438, green: 0.7568627596, blue: 0.9686274529, alpha: 1)),Color(#colorLiteral(red: 0.4745098054, green: 0.8392156959, blue: 0.9764705896, alpha: 1)) , Color(#colorLiteral(red: 0.2588235438, green: 0.7568627596, blue: 0.9686274529, alpha: 1)) , Color(#colorLiteral(red: 0.2588235438, green: 0.7568627596, blue: 0.9686274529, alpha: 1)) , Color(#colorLiteral(red: 1, green: 1, blue: 1, alpha: 1)) ], startPoint: .bottomLeading, endPoint: .topTrailing))
//    .cornerRadius(40)
//    .overlay(alignment: .topTrailing) {
//        Text("\(Taxservice.serviceprogress)")
//            .frame(width: 100 , height: 40)
//            .fontWeight(.heavy)
//            .foregroundColor(.white)
//            .background(Taxservice.serviceprogress == "待提交资料" ? .yellow : .green)
//            .cornerRadius(10)
//            .padding(.top , 10)
//            .padding(.trailing , 20)
//    }
//    .slideOverCard(isPresented: $isshowcord) {
//            VStack{
//                Text("服务进度 : \(Taxservice.serviceprogress)")
//                Text("税率 : \(Taxservice.taxrate)")
//                Text("申报周期 : \(Taxservice.taxtype)")
//                Text("周期开始日 :")
//                Text("周期结束日 :")
//                Text("申报规则 : 目的国")
//            }
//    }
//}



//struct VATView_List: View {
//    @State var taxservieList = [TaxServiceRequestrecord]()
//    @State var isshowloading : Bool = true
//    var body: some View {
//        VStack{
//            ForEach(taxservieList , id: \.self) { list in
//                VATView_One(Taxservice: list)
//            }
//        }
//        .onAppear{
//            
//            let provider = MoyaProvider<TaxServiceRequestAPI>()
//            provider.request(.pageList(pageSize: 1, pageNum: 1)) { result in
//                switch result
//                {
//                case .success(let res):
//                    do
//                    {
//                        let jsondata = res.data
//                        let data = try JSONDecoder().decode(TaxServiceRequest.self, from: jsondata)
//                        taxservieList = data.data.records
//                        self.isshowloading = false
//                        print(data)
//                    }catch let error
//                    {
//                        print(error)
//                    }
//                case .failure(let _):
//                    self.isshowloading = false
//                }
//            }
//        }
//        .overlay {
//            if isshowloading == true{
//                ProgressView( "Loading...")
//                    .frame(width: 200)
//            }
//        }
//    }
//    
//}



//NavigationView{
//    ZStack{
//      //  LinearGradient(colors: [.gray , .white , .gray.opacity(0.5) , .white , .gray.opacity(0.4)], startPoint: .topTrailing, endPoint: .bottomLeading).opacity(0.55)
//        VStack
//        {
//            HStack
//            {
//                Button {
//                    
//                } label: {
//                    Image("avatar1.jpg")
//                        .resizable()
//                        .aspectRatio(contentMode: .fit)
//                        .frame(width: 70)
//                        .cornerRadius(35)
//                        .padding(.top , 20)
//                        .padding(.leading , 20)
//                }
//                Spacer()
//                Button {
//                    
//                } label: {
//                    Image(systemName: "bell.circle")
//                        .resizable()
//                        .aspectRatio(contentMode: .fit)
//                        .frame(width: 60)
//                        .padding(.top , 20)
//                        .padding(.trailing, 20)
//                        .foregroundColor(.black)
//                }
//            }
//            .padding(.top , 30)
//            VStack
//            {
//                Text("加图表")
//            }
//            .frame(width: UIScreen.main.bounds.width , height: 200)
//            .border(.red)
//            ScrollView(.horizontal  , showsIndicators: false) {
//                HStack{
//                    Button(action: {
//                        
//                    }, label: {
//                        HStack{
//                            Image("dailishixiang")
//                            Text("代理事项")
//                                .font(.system(size: 30))
//                                .foregroundStyle(.white)
//                                .fontWeight(.heavy)
//                        }
//                        .frame(width: 170 , height: 80)
//                        .background(LinearGradient(colors: [Color(#colorLiteral(red: 0.9098039269, green: 0.4784313738, blue: 0.6431372762, alpha: 1)) , Color(#colorLiteral(red: 0.8078431487, green: 0.02745098062, blue: 0.3333333433, alpha: 1)) ,Color(#colorLiteral(red: 0.8549019694, green: 0.250980407, blue: 0.4784313738, alpha: 1)) ], startPoint: .bottomTrailing, endPoint: .topLeading))
//                        .cornerRadius(20)
//                        
//                    })
//                    Button(action: {
//                        
//                    }, label: {
//                        HStack{
//                            Image("chanpingguanli")
//                            Text("产品管理")
//                                .font(.system(size: 30))
//                                .foregroundStyle(.white)
//                                .fontWeight(.heavy)
//                        }
//                        .frame(width: 170 , height: 80)
//                        .background(LinearGradient(colors: [Color(#colorLiteral(red: 0.1764705926, green: 0.4980392158, blue: 0.7568627596, alpha: 1)) , Color(#colorLiteral(red: 0.2392156869, green: 0.6745098233, blue: 0.9686274529, alpha: 1)) ,Color(#colorLiteral(red: 0.2588235438, green: 0.7568627596, blue: 0.9686274529, alpha: 1)) ], startPoint: .bottomTrailing, endPoint: .topLeading))
//                        .cornerRadius(20)
//                    })
//                    NavigationLink(destination: WorkOrderView()) {
//                        HStack{
//                            Image("wodegongdan")
//                            Text("我的工单")
//                                .font(.system(size: 30))
//                                .foregroundStyle(.white)
//                                .fontWeight(.heavy)
//                        }
//                        .frame(width: 170 , height: 80)
//                        .background(LinearGradient(colors: [Color(#colorLiteral(red: 0.9529411793, green: 0.6862745285, blue: 0.1333333403, alpha: 1)) , Color(#colorLiteral(red: 0.9607843161, green: 0.7058823705, blue: 0.200000003, alpha: 1)) ,Color(#colorLiteral(red: 0.9686274529, green: 0.78039217, blue: 0.3450980484, alpha: 1)) ], startPoint: .bottomTrailing, endPoint: .topLeading))
//                        .cornerRadius(20)
//                    }
//                }
//            }
//            ScrollView(.vertical,showsIndicators: true) {
//                VStack
//                {
//                    
//                }
//            }
//        }
//    }
//    .ignoresSafeArea(.all)
//}
//.frame(width: UIScreen.main.bounds.width , height: UIScreen.main.bounds.height)
