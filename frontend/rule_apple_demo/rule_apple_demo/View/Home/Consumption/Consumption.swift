//
//  Consumption.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/6.
//

import SwiftUI
import SlideOverCard
import Moya


struct Consumption: View {
    @State var isshowAdd : Bool = false
    
    
    
    
    
    
    var body: some View {
        VStack{
            
            ConsumptionView_List(isshowadd: $isshowAdd)
        }
        .navigationBarItems(trailing: Button(action: {
            self.isshowAdd = true
        }, label: {
            Image(systemName: "plus")
        }))
        .navigationTitle("产品合规")
        .slideOverCard(isPresented: $isshowAdd) {
            ConsumptionView_Add(isshowAdd: $isshowAdd)
        }
    }
    
    
    
    
}

#Preview {
    
    HomeView()
        .environmentObject(ConsumptionViewModel())
        .environmentObject(EPRDocumentViewModel())
        .environmentObject(VATDocumentViewModel())
    
}
