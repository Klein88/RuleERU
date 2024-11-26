//
//  rule_apple_demoApp.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/12.
//

import SwiftUI

@main
struct rule_apple_demoApp: App {
    var body: some Scene {
        WindowGroup {
           LoginView()
                .environmentObject(UserViewModel())
                .environmentObject(VATDocumentViewModel())
                .environmentObject(EPRDocumentViewModel())
                .environmentObject(ConsumptionViewModel())
            
          // AgencyServiceInformationView()
           // TestView()
            //VATView()
           // DeclarationView_List()
           // EPRdeclatationView_List()
            //EPRView()
         // HomeView()
     //       TaxPaymentView()
       // CultivateView_Other()
        //    TabLayoutView()
         //   BaiduTranslateView()
       //     InformationView_Charts()
        //    DeclarationView_List()
        }
    }
}
