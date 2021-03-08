import Vue from 'vue';
import Component from 'vue-class-component';
import Router from 'vue-router';

Component.registerHooks([
  'beforeRouteEnter',
  'beforeRouteLeave',
  'beforeRouteUpdate' // for vue-router 2.2+
]);
const Home = () => import('../core/home/home.vue');
const Error = () => import('../core/error/error.vue');
const Register = () => import('../account/register/register.vue');
const Activate = () => import('../account/activate/activate.vue');
const ResetPasswordInit = () => import('../account/reset-password/init/reset-password-init.vue');
const ResetPasswordFinish = () => import('../account/reset-password/finish/reset-password-finish.vue');
const ChangePassword = () => import('../account/change-password/change-password.vue');
const Settings = () => import('../account/settings/settings.vue');
const JhiUserManagementComponent = () => import('../admin/user-management/user-management.vue');
const JhiUserManagementViewComponent = () => import('../admin/user-management/user-management-view.vue');
const JhiUserManagementEditComponent = () => import('../admin/user-management/user-management-edit.vue');
const JhiConfigurationComponent = () => import('../admin/configuration/configuration.vue');
const JhiDocsComponent = () => import('../admin/docs/docs.vue');
const JhiHealthComponent = () => import('../admin/health/health.vue');
const JhiLogsComponent = () => import('../admin/logs/logs.vue');
const JhiAuditsComponent = () => import('../admin/audits/audits.vue');
const JhiMetricsComponent = () => import('../admin/metrics/metrics.vue');
/* tslint:disable */
// prettier-ignore
const RoomSellDetails = () => import('../entities/room-sell-details/room-sell-details.vue');
// prettier-ignore
const RoomSellDetailsUpdate = () => import('../entities/room-sell-details/room-sell-details-update.vue');
// prettier-ignore
const RoomSellDetailsDetails = () => import('../entities/room-sell-details/room-sell-details-details.vue');
// prettier-ignore
const RoomSellInfo = () => import('../entities/room-sell-info/room-sell-info.vue');
// prettier-ignore
const RoomSellInfoUpdate = () => import('../entities/room-sell-info/room-sell-info-update.vue');
// prettier-ignore
const RoomSellInfoDetails = () => import('../entities/room-sell-info/room-sell-info-details.vue');
// prettier-ignore
const AffiliateMember = () => import('../entities/affiliate-member/affiliate-member.vue');
// prettier-ignore
const AffiliateMemberUpdate = () => import('../entities/affiliate-member/affiliate-member-update.vue');
// prettier-ignore
const AffiliateMemberDetails = () => import('../entities/affiliate-member/affiliate-member-details.vue');
// prettier-ignore
const Coupon = () => import('../entities/coupon/coupon.vue');
// prettier-ignore
const CouponUpdate = () => import('../entities/coupon/coupon-update.vue');
// prettier-ignore
const CouponDetails = () => import('../entities/coupon/coupon-details.vue');
// prettier-ignore
const PublishedCouponInfo = () => import('../entities/published-coupon-info/published-coupon-info.vue');
// prettier-ignore
const PublishedCouponInfoUpdate = () => import('../entities/published-coupon-info/published-coupon-info-update.vue');
// prettier-ignore
const PublishedCouponInfoDetails = () => import('../entities/published-coupon-info/published-coupon-info-details.vue');
// prettier-ignore
const CouponPublishedHistories = () => import('../entities/coupon-published-histories/coupon-published-histories.vue');
// prettier-ignore
const CouponPublishedHistoriesUpdate = () => import('../entities/coupon-published-histories/coupon-published-histories-update.vue');
// prettier-ignore
const CouponPublishedHistoriesDetails = () => import('../entities/coupon-published-histories/coupon-published-histories-details.vue');
// prettier-ignore
const PublishedCouponHistories = () => import('../entities/published-coupon-histories/published-coupon-histories.vue');
// prettier-ignore
const PublishedCouponHistoriesUpdate = () => import('../entities/published-coupon-histories/published-coupon-histories-update.vue');
// prettier-ignore
const PublishedCouponHistoriesDetails = () => import('../entities/published-coupon-histories/published-coupon-histories-details.vue');
// prettier-ignore
const InviteCard = () => import('../entities/invite-card/invite-card.vue');
// prettier-ignore
const InviteCardUpdate = () => import('../entities/invite-card/invite-card-update.vue');
// prettier-ignore
const InviteCardDetails = () => import('../entities/invite-card/invite-card-details.vue');
// prettier-ignore
const ApplyInviteCard = () => import('../entities/apply-invite-card/apply-invite-card.vue');
// prettier-ignore
const ApplyInviteCardUpdate = () => import('../entities/apply-invite-card/apply-invite-card-update.vue');
// prettier-ignore
const ApplyInviteCardDetails = () => import('../entities/apply-invite-card/apply-invite-card-details.vue');
// prettier-ignore
const Reservation = () => import('../entities/reservation/reservation.vue');
// prettier-ignore
const ReservationUpdate = () => import('../entities/reservation/reservation-update.vue');
// prettier-ignore
const ReservationDetails = () => import('../entities/reservation/reservation-details.vue');
// prettier-ignore
const Payment = () => import('../entities/payment/payment.vue');
// prettier-ignore
const PaymentUpdate = () => import('../entities/payment/payment-update.vue');
// prettier-ignore
const PaymentDetails = () => import('../entities/payment/payment-details.vue');
// prettier-ignore
const AccommodationSales = () => import('../entities/accommodation-sales/accommodation-sales.vue');
// prettier-ignore
const AccommodationSalesUpdate = () => import('../entities/accommodation-sales/accommodation-sales-update.vue');
// prettier-ignore
const AccommodationSalesDetails = () => import('../entities/accommodation-sales/accommodation-sales-details.vue');
// prettier-ignore
const Business = () => import('../entities/business/business.vue');
// prettier-ignore
const BusinessUpdate = () => import('../entities/business/business-update.vue');
// prettier-ignore
const BusinessDetails = () => import('../entities/business/business-details.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

Vue.use(Router);

// prettier-ignore
export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/forbidden',
      name: 'Forbidden',
      component: Error,
      meta: { error403: true }
    },
    {
      path: '/not-found',
      name: 'NotFound',
      component: Error,
      meta: { error404: true }
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/activate',
      name: 'Activate',
      component: Activate
    },
    {
      path: '/reset/request',
      name: 'ResetPasswordInit',
      component: ResetPasswordInit
    },
    {
      path: '/reset/finish',
      name: 'ResetPasswordFinish',
      component: ResetPasswordFinish
    },
    {
      path: '/account/password',
      name: 'ChangePassword',
      component: ChangePassword,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/account/settings',
      name: 'Settings',
      component: Settings,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/admin/user-management',
      name: 'JhiUser',
      component: JhiUserManagementComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    },
    {
      path: '/admin/user-management/new',
      name: 'JhiUserCreate',
      component: JhiUserManagementEditComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    },
    {
      path: '/admin/user-management/:userId/edit',
      name: 'JhiUserEdit',
      component: JhiUserManagementEditComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    },
    {
      path: '/admin/user-management/:userId/view',
      name: 'JhiUserView',
      component: JhiUserManagementViewComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    },
    {
      path: '/admin/docs',
      name: 'JhiDocsComponent',
      component: JhiDocsComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    },
    {
      path: '/admin/audits',
      name: 'JhiAuditsComponent',
      component: JhiAuditsComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    },
    {
      path: '/admin/jhi-health',
      name: 'JhiHealthComponent',
      component: JhiHealthComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    },
    {
      path: '/admin/logs',
      name: 'JhiLogsComponent',
      component: JhiLogsComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    },
    {
      path: '/admin/jhi-metrics',
      name: 'JhiMetricsComponent',
      component: JhiMetricsComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    },
    {
      path: '/admin/jhi-configuration',
      name: 'JhiConfigurationComponent',
      component: JhiConfigurationComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    }
    ,
    {
      path: '/entity/room-sell-details',
      name: 'RoomSellDetails',
      component: RoomSellDetails,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/room-sell-details/new',
      name: 'RoomSellDetailsCreate',
      component: RoomSellDetailsUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/room-sell-details/:roomSellDetailsId/edit',
      name: 'RoomSellDetailsEdit',
      component: RoomSellDetailsUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/room-sell-details/:roomSellDetailsId/view',
      name: 'RoomSellDetailsView',
      component: RoomSellDetailsDetails,
      meta: { authorities: ['ROLE_USER'] }
    }
    ,
    {
      path: '/entity/room-sell-info',
      name: 'RoomSellInfo',
      component: RoomSellInfo,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/room-sell-info/new',
      name: 'RoomSellInfoCreate',
      component: RoomSellInfoUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/room-sell-info/:roomSellInfoId/edit',
      name: 'RoomSellInfoEdit',
      component: RoomSellInfoUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/room-sell-info/:roomSellInfoId/view',
      name: 'RoomSellInfoView',
      component: RoomSellInfoDetails,
      meta: { authorities: ['ROLE_USER'] }
    }
    ,
    {
      path: '/entity/affiliate-member',
      name: 'AffiliateMember',
      component: AffiliateMember,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/affiliate-member/new',
      name: 'AffiliateMemberCreate',
      component: AffiliateMemberUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/affiliate-member/:affiliateMemberId/edit',
      name: 'AffiliateMemberEdit',
      component: AffiliateMemberUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/affiliate-member/:affiliateMemberId/view',
      name: 'AffiliateMemberView',
      component: AffiliateMemberDetails,
      meta: { authorities: ['ROLE_USER'] }
    }
    ,
    {
      path: '/entity/coupon',
      name: 'Coupon',
      component: Coupon,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/coupon/new',
      name: 'CouponCreate',
      component: CouponUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/coupon/:couponId/edit',
      name: 'CouponEdit',
      component: CouponUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/coupon/:couponId/view',
      name: 'CouponView',
      component: CouponDetails,
      meta: { authorities: ['ROLE_USER'] }
    }
    ,
    {
      path: '/entity/published-coupon-info',
      name: 'PublishedCouponInfo',
      component: PublishedCouponInfo,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/published-coupon-info/new',
      name: 'PublishedCouponInfoCreate',
      component: PublishedCouponInfoUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/published-coupon-info/:publishedCouponInfoId/edit',
      name: 'PublishedCouponInfoEdit',
      component: PublishedCouponInfoUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/published-coupon-info/:publishedCouponInfoId/view',
      name: 'PublishedCouponInfoView',
      component: PublishedCouponInfoDetails,
      meta: { authorities: ['ROLE_USER'] }
    }
    ,
    {
      path: '/entity/coupon-published-histories',
      name: 'CouponPublishedHistories',
      component: CouponPublishedHistories,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/coupon-published-histories/new',
      name: 'CouponPublishedHistoriesCreate',
      component: CouponPublishedHistoriesUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/coupon-published-histories/:couponPublishedHistoriesId/edit',
      name: 'CouponPublishedHistoriesEdit',
      component: CouponPublishedHistoriesUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/coupon-published-histories/:couponPublishedHistoriesId/view',
      name: 'CouponPublishedHistoriesView',
      component: CouponPublishedHistoriesDetails,
      meta: { authorities: ['ROLE_USER'] }
    }
    ,
    {
      path: '/entity/published-coupon-histories',
      name: 'PublishedCouponHistories',
      component: PublishedCouponHistories,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/published-coupon-histories/new',
      name: 'PublishedCouponHistoriesCreate',
      component: PublishedCouponHistoriesUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/published-coupon-histories/:publishedCouponHistoriesId/edit',
      name: 'PublishedCouponHistoriesEdit',
      component: PublishedCouponHistoriesUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/published-coupon-histories/:publishedCouponHistoriesId/view',
      name: 'PublishedCouponHistoriesView',
      component: PublishedCouponHistoriesDetails,
      meta: { authorities: ['ROLE_USER'] }
    }
    ,
    {
      path: '/entity/invite-card',
      name: 'InviteCard',
      component: InviteCard,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/invite-card/new',
      name: 'InviteCardCreate',
      component: InviteCardUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/invite-card/:inviteCardId/edit',
      name: 'InviteCardEdit',
      component: InviteCardUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/invite-card/:inviteCardId/view',
      name: 'InviteCardView',
      component: InviteCardDetails,
      meta: { authorities: ['ROLE_USER'] }
    }
    ,
    {
      path: '/entity/apply-invite-card',
      name: 'ApplyInviteCard',
      component: ApplyInviteCard,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/apply-invite-card/new',
      name: 'ApplyInviteCardCreate',
      component: ApplyInviteCardUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/apply-invite-card/:applyInviteCardId/edit',
      name: 'ApplyInviteCardEdit',
      component: ApplyInviteCardUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/apply-invite-card/:applyInviteCardId/view',
      name: 'ApplyInviteCardView',
      component: ApplyInviteCardDetails,
      meta: { authorities: ['ROLE_USER'] }
    }
    ,
    {
      path: '/entity/reservation',
      name: 'Reservation',
      component: Reservation,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/reservation/new',
      name: 'ReservationCreate',
      component: ReservationUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/reservation/:reservationId/edit',
      name: 'ReservationEdit',
      component: ReservationUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/reservation/:reservationId/view',
      name: 'ReservationView',
      component: ReservationDetails,
      meta: { authorities: ['ROLE_USER'] }
    }
    ,
    {
      path: '/entity/payment',
      name: 'Payment',
      component: Payment,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/payment/new',
      name: 'PaymentCreate',
      component: PaymentUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/payment/:paymentId/edit',
      name: 'PaymentEdit',
      component: PaymentUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/payment/:paymentId/view',
      name: 'PaymentView',
      component: PaymentDetails,
      meta: { authorities: ['ROLE_USER'] }
    }
    ,
    {
      path: '/entity/accommodation-sales',
      name: 'AccommodationSales',
      component: AccommodationSales,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/accommodation-sales/new',
      name: 'AccommodationSalesCreate',
      component: AccommodationSalesUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/accommodation-sales/:accommodationSalesId/edit',
      name: 'AccommodationSalesEdit',
      component: AccommodationSalesUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/accommodation-sales/:accommodationSalesId/view',
      name: 'AccommodationSalesView',
      component: AccommodationSalesDetails,
      meta: { authorities: ['ROLE_USER'] }
    }
    ,
    {
      path: '/entity/business',
      name: 'Business',
      component: Business,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/business/new',
      name: 'BusinessCreate',
      component: BusinessUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/business/:businessId/edit',
      name: 'BusinessEdit',
      component: BusinessUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/business/:businessId/view',
      name: 'BusinessView',
      component: BusinessDetails,
      meta: { authorities: ['ROLE_USER'] }
    }
    // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
  ]
});
