//
//  LoginView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/15.
//

import SwiftUI
import Moya

struct LoginView: View {
    @State var index = 0
    @State var isFocused = true
    
    func hideKeyboard(){
        UIApplication.shared.sendAction(#selector(UIResponder.resignFirstResponder), to: nil, from: nil, for: nil)
    }
    var body: some View {
        NavigationView{
            GeometryReader {_ in
                VStack {
                    Spacer()
                    ZStack {
//                        SignUp(index: self.$index, isFocused: self.$isFocused)
//                            .zIndex(Double(self.index))
                        Login(index: self.$index, isFocused: self.$isFocused)
                    }
                    .offset(y: isFocused ? -60 : 0)
                    .animation(.easeInOut)
                    Spacer()
                }
                .background(MotionAnimationView(colorName: Color.blue.opacity(0.5)))
            }
            .edgesIgnoringSafeArea(.all)
            .onTapGesture {
                self.isFocused = false
                self.hideKeyboard()
            }
        }
    }
}


struct CShape1: Shape {
    func path(in rect: CGRect) -> Path {
        return Path{path in
            path.move(to: CGPoint(x: rect.width, y: 100))
            path.addLine(to: CGPoint(x: rect.width, y: rect.height))
            path.addLine(to: CGPoint(x: 0, y: rect.height))
            path.addLine(to: CGPoint(x: 0, y: 0))
        }
    }
}

struct CShape2: Shape {
    func path(in rect: CGRect) -> Path {
        return Path{path in
            path.move(to: CGPoint(x: 0, y: 100))
            path.addLine(to: CGPoint(x: 0, y: rect.height))
            path.addLine(to: CGPoint(x: rect.width, y: rect.height))
            path.addLine(to: CGPoint(x: rect.width, y: 0))
        }
    }
}



struct Login: View {
    @State var username = ""//电话
    @State var password = ""//密码
    @Binding var index: Int
    @State var settingPagePresentedLogin: Bool = false
    @State var showAlert = false
    @State var isnavigate : Bool = false
    @Binding var isFocused: Bool
    @EnvironmentObject var userViewModel : UserViewModel
    @State var isToRegisiter : Bool = false
    func hideKeyboard(){
        UIApplication.shared.sendAction(#selector(UIResponder.resignFirstResponder), to: nil, from: nil, for: nil)
    }
    
    var body: some View {
        ZStack(alignment: .bottom) {
            VStack {
                HStack {
                    VStack(spacing: 10) {
                        Text("登录")
                            .foregroundColor(self.index == 0 ? .primary : .gray)
                            .font(.title)
                            .fontWeight(.bold)
                        
                        Capsule()
                            .fill(self.index == 0 ? Color.blue : Color.clear)
                            .frame(width: 100, height: 5)
                    }
                    
                    Spacer(minLength: 0)
                }
                .padding(.top, 30)
                
                VStack(spacing: 10) {
                    HStack(spacing: 15) {
                        Image(systemName: "phone.fill")
                            .foregroundColor(Color.primary)
                            .frame(width: 20)
                        
                        TextField("请输入用户名", text: self.$username)
                            .onTapGesture {
                                self.isFocused = true
                            }
                            .onSubmit {
                                self.isFocused = false
                            }
                    }
                    Divider().background(Color.white.opacity(0.5))
                }
                .padding(.horizontal)
                .padding(.top, 40)
                
                VStack(spacing: 10) {
                    HStack(spacing: 15) {
                        Image(systemName: "lock.fill")
                            .foregroundColor(Color.primary)
                            .frame(width: 20)
                        
                        SecureField("请输入密码", text: self.$password)
                            .textContentType(.password)
                            .onTapGesture {
                                self.isFocused = true
                            }
                            .onSubmit {
                                self.isFocused = false
                            }
                    }
                    
                    Divider().background(Color.white.opacity(0.5))
                }
                .padding(.horizontal)
                .padding(.top, 30)
                
                HStack {
                    Button(action: {
                        self.isToRegisiter = true
                    }, label: {
                        Text("注册")
                        NavigationLink(destination: LoginView_Regisiter(isback: $isToRegisiter),isActive: $isToRegisiter ,label: {EmptyView()})
                    })
                    Spacer(minLength: 0)
                    
                    Button {
                        
                    } label: {
                        Text("忘记密码")
                            .foregroundColor(Color.primary)
                    }
                }
                .padding(.horizontal)
                .padding(.top, 30)
            }
            .frame(height: 275)
            .padding()
            .padding(.bottom, 65)
            .background(.blue.opacity(0.4))
            .clipShape(CShape1())
            .contentShape(CShape1())
            .shadow(color: .primary.opacity(0.3), radius: 5, x: 0, y: -5)
            .onTapGesture {
                self.index = 0
            }
            .cornerRadius(35)
            .padding(.horizontal, 20)
            
            Button {
                self.hideKeyboard()
                isFocused = false
                let provider = MoyaProvider<UserRequestAPI>()
                
                provider.request(.login(username: self.username, password: self.password)) { result in
                    switch result
                    {
                    case.success(let res):
                        do
                        {
                            let jsondata = res.data
                            let data = try JSONDecoder().decode(NewUserRequest.self, from: jsondata)
                            print(data)
                            
                            if data.code == 20000
                            {
                                userViewModel.islogin = true
                            }
                        }catch let error
                        {
                            print(error)
                        }
                    case .failure(let error):
                        print(error)
                    }
                }
                //获取User信息
                
                let providerCompanyInfo = MoyaProvider<CompanyinfoRequestAPI>()
                
                providerCompanyInfo.request(.pageList(pagesize: 1 , pagenum: 1)) { result in
                    switch result
                    {
                    case .success(let req):
                        do
                        {
                            let jsondata = req.data
                            let data = try JSONDecoder().decode(CompanyinfoRequest.self, from: jsondata)
                            //print(data)
                            userViewModel.companyinfoAll = data.data.records
                            print(userViewModel.companyinfoAll)
                        }catch let error
                        {
                            print(error)
                        }
                    case .failure(let error):
                        print(error)
                    }
                }
            }label: {
                Text("→")
                    .font(.title)
                    .fontWeight(.bold)
                    .foregroundColor(.white)
                    .padding(.vertical)
                    .padding(.horizontal,50)
                    .background(MotionAnimationView(colorName: Color.blue.opacity(0.8)))
                    .clipShape(Circle())
                NavigationLink(destination: TabLayoutView(),isActive: $userViewModel.islogin, label: {EmptyView()})
            }
            .offset(y: 25)
            .opacity(self.index == 0 ? 1 : 0)
        }
        .alert(isPresented: self.$showAlert, content: {
            Alert(title: Text("提示"), message: Text("登录失败，请检查后重新登录"), dismissButton: .default(Text("关闭"), action: {
                showAlert = false
            }))
        })
        .fullScreenCover(isPresented: $settingPagePresentedLogin, content: {
            ContentView()
        })
    }
}

struct SignUp: View {
    @State var username = ""//手机号
    @State var password = ""//密码
    @State var keyword = ""//验证码
    @Binding var index: Int
    @Binding var isFocused: Bool
    
    var body: some View {
        ZStack(alignment: .bottom) {
            VStack {
                HStack {
                    Spacer(minLength: 0)
                    
                    VStack(spacing: 10) {
                        Text("注册")
                            .foregroundColor(self.index == 1 ? .primary : Color.gray)
                            .font(.title)
                            .fontWeight(.bold)
                        
                        Capsule()
                            .fill(self.index == 1 ? Color.blue : Color.clear)
                            .frame(width: 100, height: 5)
                    }
                }
                .padding(.top, 40)
                
                VStack(spacing: 10) {
                    HStack(spacing: 15) {
                        Image(systemName: "phone.fill")
                            .foregroundColor(Color.primary)
                            .frame(width: 20)
                        
                        TextField("请输入用户名", text: self.$username)
                            .onTapGesture {
                                self.isFocused = true
                            }
                            .onSubmit {
                                self.isFocused = false
                            }
                    }
                    
                    Divider().background(Color.white.opacity(0.5))
                }
                .padding(.horizontal)
                .padding(.top, 40)
                
                VStack(spacing: 10) {
                    HStack(spacing: 15) {
                        Image(systemName: "lock.fill")
                            .foregroundColor(Color.primary)
                            .frame(width: 20)
                        
                        SecureField("请输入密码", text: self.$password)
                            .onTapGesture {
                                self.isFocused = true
                            }
                            .onSubmit {
                                self.isFocused = false
                            }
                    }
                    
                    Divider().background(Color.white.opacity(0.5))
                }
                .padding(.horizontal)
                .padding(.top, 30)
                
                VStack(spacing: 10) {
                    HStack(spacing: 15) {
                        Image(systemName: "key.horizontal.fill")
                            .foregroundColor(Color.primary)
                            .frame(width: 20)
                        
                        SecureField("请输入验证码", text: self.$keyword)
                            .onTapGesture {
                                self.isFocused = true
                            }
                            .onSubmit {
                                self.isFocused = false
                            }
                        
                        Button {
                            
                        } label: {
                            Text("获取验证码")
                        }
                    }
                    
                    Divider().background(Color.white.opacity(0.5))
                }
                .padding(.horizontal)
                .padding(.top, 30)
            }
            .frame(height: 275)
            .padding()
            .padding(.bottom, 65)
            .background(.blue.opacity(0.2))
            .clipShape(CShape2())
            .contentShape(CShape2())
            .shadow(color: .primary.opacity(0.3), radius: 5, x: 0, y: -5)
            .onTapGesture {
                self.index = 1
            }
            .cornerRadius(35)
            .padding(.horizontal, 20)
            
            Button {
                let prodiver = MoyaProvider<UserRequestAPI>()
                
                
               
            } label: {
                Text("注册")
                    .font(.title)
                    .fontWeight(.bold)
                    .foregroundColor(.white)
                    .padding(.vertical)
                    .padding(.horizontal,50)
                    .background(MotionAnimationView(colorName: Color.blue.opacity(0.8)))
                    .clipShape(Circle())
            }
            .offset(y: 25)
            .opacity(self.index == 1 ? 1 : 0)
        }
    }
}

struct MotionAnimationView: View {
    let colorName: Color
    //MARK: - Properties
    @State private var randomCircle = Int.random(in: 12...16)
    @State private var isAnimating = false
    
    // MARK: - Functions
    // 1. 随机坐标
    func randomCoordinate(max: CGFloat) -> CGFloat {
        return CGFloat.random(in: 0...max)
    }
    
    // 2. 随机尺寸
    func randomSize() -> CGFloat {
        CGFloat(Int.random(in: 10...300))
    }
    
    // 3. 随机缩放比
    func randomScale() -> CGFloat {
        CGFloat(Double.random(in: 0.1...2.0))
    }
    
    // 4. 随机速度
    func randomSpeed() -> Double {
        Double.random(in: 0.025...1.0)
    }
    // 5. 随机延时
    func randomDelay() -> Double {
        Double.random(in: 0...2)
    }
    
    //MARK: - Body
    var body: some View {
        GeometryReader { geometry in
            ZStack {
                ForEach(0 ..< randomCircle, id: \.self) { item in
                    Circle()
                        .foregroundColor(colorName.opacity(0.2))
                        .frame(width: randomSize(), height: randomSize(), alignment: .center)
                        .scaleEffect(isAnimating ? randomScale() : 1)
                        .position(x: randomCoordinate(max: geometry.size.width),
                                  y: randomCoordinate(max: geometry.size.height))
                        .animation(
                            Animation.interpolatingSpring(stiffness: 0.5, damping: 0.5)
                                .repeatForever()
                                .speed(randomSpeed())
                                .delay(randomDelay())
                        )
                        .onAppear {
                            isAnimating = true
                        }
                } //: Loop
            } //: ZStack
            .drawingGroup()
        } //: Geometry
        .ignoresSafeArea()
    }
}


#Preview {
    LoginView()
        .environmentObject(UserViewModel())
        .environmentObject(VATDocumentViewModel())
        .environmentObject(EPRDocumentViewModel())
        .environmentObject(ConsumptionViewModel())
}
