//
//  CultivateView_Other.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/13.
//

import SwiftUI

struct CultivateView_Other: View {
    @State var texts : [String] = ["英国税务局","德国税务局","法国税务局","意大利税务局"]
    @State var text_urls : [String] = ["https://www.gov.uk/government/organisations/hm-revenue-customs","https://www.berlin.de/sen/finanzen/steuern/finanzaemter/neukoelln/","https://www.impots.gouv.fr/accueil","https://www.agenziaentrate.gov.it/portale/"]
    @State var num : Int = 0
    var body: some View {
        Form{
            
            
            Section{
                
                Menu{
                    ForEach(0 ..< texts.count , id: \.self)
                    {
                        it in
                        Button(action: {
                            self.num = it
                        }, label: {
                            Text(texts[it])
                        })
                    }
                }label: {
                    HStack{
                        Text("\(texts[self.num])")
                        Spacer()
                        Text("切换")
                    }
                }
                
            }
            Section(header: Text("翻译")) {
                BaiduTranslateView()
                    .scaleEffect(0.7)
            }
            
            Section{
                WebView(url: URL(string: text_urls[num])!)
                    .frame(height: UIScreen.main.bounds.height)
            }
            
            Section(header: Text("维基百科 : 关于VAT的介绍").font(.system(size: 25)).fontWeight(.heavy).foregroundStyle(.black)) {
                
                    Link("维基百科 : 关于VAT的介绍 -> ", destination: URL(string: "https://zh.wikipedia.org/wiki/增值税")!)
            }
            Section(header: Text("维基百科 : 关于GDPR的介绍").font(.system(size: 25)).fontWeight(.heavy).foregroundStyle(.black)) {
                Link("维基百科 : 关于GDPR的介绍 -> ", destination: URL(string: "https://zh.wikipedia.org/wiki/歐盟一般資料保護規範")!)
            }
       
            
        }
        .navigationTitle("外部知识链接")
    }
}

#Preview {
    CultivateView_Other()
}
