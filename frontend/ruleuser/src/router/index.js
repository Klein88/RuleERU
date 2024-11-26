import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

const routes = [
  {
    path: '/',
    name: 'login',
    component: () => import('../views/Login/Login.vue')
  },
  {
    path: '/home',
    name: 'home',
    component: Home,
    children:[
      {
        path: '/staging',
        name: 'staging',
        component: () => import('@/views/Staging/Staging.vue')
      },
      {
        path: '/companyinfo',
        name: 'companyinfo',
        component: () => import('@/views/Staging/CompanyInfo/CompanyInfo.vue')
      },
      {
        path: '/companyinfoupdate/:name',
        name: 'companyinfoupdate',
        component: () => import('@/views/Staging/CompanyInfo/CompanyInfoUpdate.vue')
      },
      {
        path: '/products',
        name: 'products',
        component: () => import('@/views/Staging/Products/Products.vue')
      },
      {
        path: '/productsadd',
        name: 'productsadd',
        component: () => import('@/views/Staging/Products/ProductsAdd.vue')
      },
      {
        path: '/productsupdate/:id',
        name: 'productsupdate',
        component: () => import('@/views/Staging/Products/ProductsUpdate.vue')
      },
      {
        path: '/workorders',
        name: 'workorders',
        component: () => import('@/views/Staging/WorkOrders/WorkOrders.vue')
      },
      {
        path: '/workordersadd',
        name: 'workordersadd',
        component: () => import('../views/Staging/WorkOrders/WorkOrdersAdd.vue')
      },
      {
        path: '/localtaxpolicy',
        name: 'localtaxpolicy',
        component: () => import('../views/Tax/LocalTaxPolicy/LocalTaxPolicy.vue')
      },
      {
        path: '/taxservice',
        name: 'taxservice',
        component: () => import('@/views/Tax/TaxService/TaxService.vue')
      },
      {
        path: '/taxdeclaration',
        name: 'taxdeclaration',
        component: () => import('../views/Tax/TaxDeclaration/TaxDeclaration.vue')
      },
      {
        path: '/taxdeclarationadd/:id',
        name: 'taxdeclarationadd',
        component: () => import('../views/Tax/TaxDeclaration/TaxDeclarationAdd.vue')
      },
      {
        path: '/initiatedeclaration1',
        name: 'initiatedeclaration1',
        component: () => import('../views/Tax/TaxDeclaration/InitiateDeclaration1.vue')
      },
      {
        path: '/initiatedeclaration2',
        name: 'initiatedeclaration2',
        component: () => import('../views/Tax/TaxDeclaration/InitiateDeclaration2.vue')
      },
      {
        path: '/initiatedeclaration3',
        name: 'initiatedeclaration3',
        component: () => import('../views/Tax/TaxDeclaration/InitiateDeclaration3.vue')
      },
      {
        path: '/initiatedeclaration4',
        name: 'initiatedeclaration4',
        component: () => import('../views/Tax/TaxDeclaration/InitiateDeclaration4.vue')
      },
      {
        path: '/initiatedeclaration5',
        name: 'initiatedeclaration5',
        component: () => import('../views/Tax/TaxDeclaration/InitiateDeclaration5.vue')
      },
      {
        path: '/taxpayment',
        name: 'taxpayment',
        component: () => import('@/views/Tax/TaxPayment/TaxPayment.vue')
      },
      {
        path: '/taxpaymentadd',
        name: 'taxpaymentadd',
        component: () => import('../views/Tax/TaxPayment/TaxPaymentAdd.vue')
      },
      {
        path: '/taxpaymentupdate/:id',
        name: 'taxpaymentupdate',
        component: () => import('../views/Tax/TaxPayment/TaxPaymentUpdate.vue')
      },
      {
        path: '/taxrefund',
        name: 'taxrefund',
        component: () => import('@/views/Tax/TaxRefund/TaxRefund.vue')
      },
      {
        path: '/taxrefundadd',
        name: 'taxrefundadd',
        component: () => import('../views/Tax/TaxRefund/TaxRefundAdd.vue')
      },
      {
        path: '/eprservice',
        name: 'eprservice',
        component: () => import('@/views/Environment/EPRService/EPRService.vue')
      },
      {
        path: '/eprserviceadd',
        name: 'eprserviceadd',
        component: () => import('@/views/Environment/EPRService/EPRServiceAdd.vue')
      },
      {
        path: '/eprserviceinformation/:id',
        name: 'eprserviceinformation',
        component: () => import('../views/Environment/EPRService/EPRServiceInformation.vue')
      },
      {
        path: '/eprdeclaration',
        name: 'eprdeclaration',
        component: () => import('../views/Environment/EPRDeclaration/EPRDeclaration.vue')
      },
      {
        path: '/eprdeclarationadd',
        name: 'eprdeclarationadd',
        component: () => import('../views/Environment/EPRDeclaration/EPRDeclarationAdd.vue')
      },
      {
        path: '/eprdeclarationupdate/:id',
        name: 'eprdeclarationupdate',
        component: () => import('../views/Environment/EPRDeclaration/EPRDeclarationUpdate.vue')
      },
      {
        path: '/eprpayment',
        name: 'eprpayment',
        component: () => import('../views/Environment/EPRPayment/EPRPayment.vue')
      },
      {
        path: '/compliancetesting',
        name: 'compliancetesting',
        component: () => import('../views/Product/ProductCompliance/ComplianceTesting.vue')
      },
      {
        path: '/compliancetestingadd',
        name: 'compliancetestingadd',
        component: () => import('../views/Product/ProductCompliance/ComplianceTestingAdd.vue')
      },
      {
        path: '/documentapplication',
        name: 'documentapplication',
        component: () => import('../views/Product/ProductCompliance/DocumentApplication.vue')
      },
      {
        path: '/documentapplicationadd',
        name: 'documentapplicationadd',
        component: () => import('../views/Product/ProductCompliance/DocumentApplicationAdd.vue')
      },
      {
        path: '/documentapplicationupdate/:id',
        name: 'documentapplicationupdate',
        component: () => import('../views/Product/ProductCompliance/DocumentApplicationUpdate.vue')
      },
      {
        path: '/gdpr',
        name: 'gdpr',
        component: () => import('../views/Privacy/GDPR.vue')
      },
      {
        path: '/questionnaireinvestigation',
        name: 'questionnaireinvestigation',
        component: () => import('../views/Privacy/QuestionnaireInvestigation.vue')
      },
      {
        path: '/vat',
        name: 'vat',
        component: () => import('../views/Data/Vat.vue')
      },
      {
        path: '/food',
        name: 'food',
        component: () => import('../views/Data/Food.vue')
      },
      {
        path: '/huaxuepin',
        name: 'huaxuepin',
        component: () => import('../views/Data/Huaxuepin.vue')
      },
      {
        path: '/jixie',
        name: 'jixie',
        component: () => import('../views/Data/Jixie.vue')
      },
      {
        path: '/yuancailiao',
        name: 'yuancailiao',
        component: () => import('../views/Data/Yuancailiao.vue')
      },
      {
        path: '/myworkorders',
        name: 'myworkorders',
        component: () => import('../views/CustomerService/MyWorkOrders.vue')
      },
      {
        path: '/myworkordersadd',
        name: 'myworkordersadd',
        component: () => import('../views/CustomerService/MyWorkOrdersAdd.vue')
      },
      {
        path: '/onlineservice',
        name: 'onlineservice',
        component: () => import('../views/CustomerService/OnlineService.vue')
      },
      {
        path: '/training',
        name: 'training',
        component: () => import('../views/Training/Training.vue')
      }
    ]
  },
  // {
  //   path: '/onlineservice',
  //   name: 'onlineservice',
  //   component: () => import('../views/CustomerService/OnlineService.vue')
  // },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
