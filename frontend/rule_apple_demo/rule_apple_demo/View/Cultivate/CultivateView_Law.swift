//
//  CultivateView_Law.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/12.
//

import SwiftUI
import SlideOverCard



struct CultivateView_Law: View {
    var body: some View{
        Form{
            Section{
                    NavigationLink(destination: CultivateView_Law_VAT(), label: {
                        
                        HStack
                        {
                            Image(.什么是VATIntroduction)
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                            
                            Text("VAT法规  ->")
                                .font(.system(size: 20))
                                .fontWeight(.heavy)
                        }
                        
                    })
            }
            Section{
                NavigationLink(destination: CultivateView_Law_EPR(), label: {
                    
                    HStack
                    {
                        Image(.什么是EPRIntroduction)
                            .resizable()
                            .aspectRatio(contentMode: .fit)
                        Text("EPR法规  ->")
                            .font(.system(size: 20))
                            .fontWeight(.heavy)
                    }
                })
            }
            
            Section(header: Text("欧盟法规查询网站").font(.system(size: 30)).fontWeight(.heavy).foregroundStyle(.black)){
                
                WebView(url: URL(string: "https://eur-lex.europa.eu/homepage.html")!)
                    .frame(height: UIScreen.main.bounds.height)
                
            }
            
        }
    }
}

#Preview {
    CultivateView_Law()
}
