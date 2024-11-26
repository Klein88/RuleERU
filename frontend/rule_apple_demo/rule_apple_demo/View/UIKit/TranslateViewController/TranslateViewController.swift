//
//  TranslateViewController.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/1.
//

import UIKit
import Moya
import SwiftUI

class TranslateViewController: UIViewController{

    
    var TextView  = UITextView()
    var dstView = UITextView()
    var TranslateButton = UIButton()
    var stackView = UIStackView()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        TextView.frame = CGRect(x: 0, y: 100, width: UIScreen.main.bounds.width - 50, height: 200)
        TextView.backgroundColor = UIColor(Color(.gray).opacity(0.1))
        TextView.layer.borderColor = .init(red: 255 / 255, green: 0 / 255, blue: 0 / 255, alpha: 1.0)
        dstView.frame = CGRect(x: 0, y: 100, width: UIScreen.main.bounds.width, height: 200)
        dstView.backgroundColor = UIColor(Color(.gray).opacity(0.1))
        dstView.layer.borderColor = .init(red: 255 / 255, green: 0 / 255, blue: 0 / 255, alpha: 1.0)
        TranslateButton.setTitle("翻译", for: .application)
        TranslateButton.addTarget(self, action: #selector(request1), for: .touchUpInside)
        
        stackView.axis = .vertical
        stackView.frame = CGRect(x: 0, y: 0, width: self.view.frame.width, height: self.view.frame.height)
        stackView.addArrangedSubview(TextView)
        stackView.addArrangedSubview(TranslateButton)
        stackView.addArrangedSubview(dstView)
     //   stackView.backgroundColor = .red
        
        self.view.addSubview(stackView)
       
    }
    
    
    
    @objc
    func request1()
    {
        let prodiver = MoyaProvider<TranslateAPI>()
        prodiver.request(.translate(query: self.TextView.text, from: "zh", to: "en")) { result in
            switch result
            {
            case .success(let req):
                do
                {
                    let jsondata = req.data
                    let data = try JSONDecoder().decode(TranslateRequest.self, from: jsondata)
                    print(data)
                    self.dstView.text = data.trans_result[0].dst
                }catch let error
                {
                    print(error)
                }
            case.failure(_):
                break
            }
        }
    }

    

}
