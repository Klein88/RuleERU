//
//  ContentView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/12.
//

import SwiftUI


struct ContentView: View {
    var body: some View{
        GeometryReader{
            geometry in
            VStack
            {
                Text("\(geometry.frame(in: .global).midX)")
                Text("\(geometry.frame(in: .global).midX)")
                Text("\(geometry.frame(in: .global).midX)")
            }
            .border(.red)
        }
        .border(.red)
    }
}

#Preview {
    ContentView()
}
