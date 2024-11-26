//
//  BaiduTranslateView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/13.
//

import SwiftUI
import Moya



struct BaiduTranslateView: View {
    @State var translate_text_before : String = ""
    let translate_before_languages_chinese : [String] = ["中文","英语","德语","法语","意大利语"]
    @State var num_before : Int = 0
    let translate_before_languages : [String] = ["zh","en","de","fra","it"]
    
    let translate_after_languages_chinese : [String] = ["中文","英语","德语","法语","意大利语"]
    @State var num_after : Int = 0
    let translate_after_languages : [String] = ["zh","en","de","fra","it"]
    @State var translate_text_after : String = ""
    var body: some View {
        VStack{
            HStack
            {
                VStack{
                    Menu{
                        ForEach(0 ..< translate_before_languages_chinese.count)
                        {
                            it in
                            Button(action: {
                                self.num_before = it
                            }, label: {
                                Text(translate_before_languages_chinese[it])
                            })
                        }
                    }label: {
                        Text("\(translate_before_languages_chinese[self.num_before])")
                    }
                    ZStack{
                        Color.blue
                        
                            TextField("请输入需要翻译的内容", text: $translate_text_before)
                                .frame(width: UIScreen.main.bounds.width / 2 - 40 , height: 90)
                                .background(.white)
                                .cornerRadius(10)
                        }
                    .frame(width: UIScreen.main.bounds.width / 2 - 30 , height: 100)
                    .cornerRadius(10)
                
                }
                
                Image(systemName: "repeat")
                VStack{
                    Menu{
                        ForEach(0 ..< translate_after_languages_chinese.count)
                        {
                            it in
                            Button(action: {
                                self.num_after = it
                            }, label: {
                                Text(translate_after_languages_chinese[it])
                            })
                        }
                    }label: {
                        Text("\(translate_after_languages_chinese[self.num_after])")
                    }
                    ZStack{
                        Color.blue
                        
                        TextField("已经翻译的内容", text: $translate_text_after)
                            .frame(width: UIScreen.main.bounds.width / 2 - 40 , height: 90)
                            .background(.white)
                            .cornerRadius(10)
                    }
                    .frame(width: UIScreen.main.bounds.width / 2 - 30 , height: 100)
                    .cornerRadius(10)
                }
            }
            
            
            Button(action: {
                let prodiver = MoyaProvider<TranslateAPI>()
                
                prodiver.request(.translate(query: self.translate_text_before, from: self.translate_before_languages[self.num_before], to: self.translate_after_languages[self.num_after])) { result in
                    switch result
                    {
                    case .success(let req):
                        do
                        {
                            let jsondata = req.data
                            let data = try JSONDecoder().decode(TranslateRequest.self, from: jsondata)
                            print(data)
                            self.translate_text_after = data.trans_result[0].dst
                        }catch let error
                        {
                            print(error)
                        }
                        
                    case .failure(_):
                        break
                    }
                }
            }, label: {
                Text("翻译")
                    .font(.system(size: 20))
                    .fontWeight(.heavy)
                    .foregroundStyle(.white)
                    .frame(width: 100 , height: 60)
                    .background(.blue)
                    .cornerRadius(10)
            })
            .padding(.top , 20)
        }
    }
}

#Preview {
    BaiduTranslateView()
}
