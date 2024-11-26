//
//  CultivateView_market.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/13.
//

import SwiftUI

struct CultivateView_market: View {
    var body: some View {
        WebView(url: URL(string: "https://ec.europa.eu/eurostat/cache/infographs/economy/ecotrends/index.html")!)
    }
}

#Preview {
    CultivateView_market()
}
