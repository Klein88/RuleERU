//
//  VATView_List.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/24.
//

import SwiftUI
import Moya

struct VATView_List: View {
    @Binding var isshowaddview : Bool
    @State var taxservieList : [TaxServiceRequestrecord] = [TaxServiceRequestrecord]()
    @State var isshowloading : Bool = false
    var body: some View
    {
        Form{
            ForEach(taxservieList , id: \.self)
            {
                it in
                Section{
                    VATView_One(Taxservice: it)
                }
            }
            .navigationTitle("VAT税号管理")
        }
        .onAppear{
            let provider = MoyaProvider<TaxServiceRequestAPI>()
            provider.request(.pageList(pageSize: 1, pageNum: 1)) { result in
                switch result
                {
                case .success(let res):
                    do
                    {
                        let jsondata = res.data
                        let data = try JSONDecoder().decode(TaxServiceRequest.self, from: jsondata)
                        taxservieList = data.data.records
                        self.isshowloading = false
                        print(data)
                    }catch let error
                    {
                        print(error)
                    }
                case .failure(_):
                    self.isshowloading = false
                }
            }
        }
        .overlay {
            if isshowloading{
                ProgressView("Loading...")
                    .frame(width: 200)
            }
        }
        .onChange(of: isshowaddview) { newvalue in
            let provider = MoyaProvider<TaxServiceRequestAPI>()
            provider.request(.pageList(pageSize: 1, pageNum: 1)) { result in
                switch result
                {
                case .success(let res):
                    do
                    {
                        let jsondata = res.data
                        let data = try JSONDecoder().decode(TaxServiceRequest.self, from: jsondata)
                        taxservieList = data.data.records
                        self.isshowloading = false
                        print(data)
                    }catch let error
                    {
                        print(error)
                    }
                case .failure(_):
                    self.isshowloading = false
                }
            }
        }
    }
}

#Preview {
    VATView()
}
