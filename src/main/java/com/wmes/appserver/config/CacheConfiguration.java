package com.wmes.appserver.config;

import com.wmes.appserver.domain.standard.Business;
import io.github.jhipster.config.JHipsterProperties;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.jsr107.Eh107Configuration;
import org.hibernate.cache.jcache.ConfigSettings;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        JHipsterProperties.Cache.Ehcache ehcache = jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcache.getTimeToLiveSeconds())))
                .build());
    }

    @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(javax.cache.CacheManager cacheManager) {
        return hibernateProperties -> hibernateProperties.put(ConfigSettings.CACHE_MANAGER, cacheManager);
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            createCache(cm, com.wmes.appserver.repository.UserRepository.USERS_BY_LOGIN_CACHE);
            createCache(cm, com.wmes.appserver.repository.UserRepository.USERS_BY_EMAIL_CACHE);
            createCache(cm, com.wmes.appserver.domain.User.class.getName());
            createCache(cm, com.wmes.appserver.domain.Authority.class.getName());
            createCache(cm, com.wmes.appserver.domain.User.class.getName() + ".authorities");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName());
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".managerInfos");

            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".couponHistories");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".accommodationSales");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".adminUserRoles");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".adminUserAuths");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".boards");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".boardDetails");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".inquiryAnswers");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".managerWorkHistories");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".terms");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".affiliateCommissionSettings");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".managerCommissionSettingUsers");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".managerCommissionApplyUsers");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".pGCommissionSettingUsers");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".pGCommissionApplyUsers");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".investmentCommissionSettingUsers");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".investmentCommissionApplyUsers");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".mileageSettings");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".inflowPaths");
            createCache(cm, com.wmes.appserver.domain.InflowPath.class.getName());
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".couponPublishers");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".hoEvents");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".hoNotices");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".categories");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".bookmarks");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".timeApplyManagers");
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".settingUsers");
            createCache(cm, com.wmes.appserver.domain.Category.class.getName());
            createCache(cm, com.wmes.appserver.domain.AdminHistories.class.getName());
            createCache(cm, com.wmes.appserver.domain.AdminUser.class.getName() + ".InviteRequestHistories");
            createCache(cm, Business.class.getName());
            // jhipster-needle-ehcache-add-entry
        };
    }

    private void createCache(javax.cache.CacheManager cm, String cacheName) {
        javax.cache.Cache<Object, Object> cache = cm.getCache(cacheName);
        if (cache != null) {
            cm.destroyCache(cacheName);
        }
        cm.createCache(cacheName, jcacheConfiguration);
    }

}
