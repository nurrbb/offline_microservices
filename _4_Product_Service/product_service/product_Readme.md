# Product Service
[GitHub](https://github.com/nurrbb/offline_microservices/tree/master/_4_Product_Service/product_service)

--

## Çalıştırma Sıralama
```sh
1-) Eureka Server 
2-) Config Server
3-) Api Gateway
4-) Product Server 
```
---


## URL
```sh
http://llocalhost:8761
http://localhost:8761/eureka/apps/
http://localhost:8761/eureka/apps/PRODUCT-SERVICE
http://localhost:8761/eureka/apps/
http://localhost:8888/application/default

```
---



## EnableEurekaClient Ve EnableDiscoveryClient
`@EnableEurekaClient` ve `@EnableDiscoveryClient` anotasyonları, Spring Cloud uygulamalarında servis keşfini etkinleştirmek için kullanılır, ancak farklı kapsam ve esneklik sunarlar. İşte bu iki anotasyon arasındaki temel farklar:

### 1. **@EnableEurekaClient**
- **Özellikler:**
    - `@EnableEurekaClient`, Spring Cloud uygulamanızı bir **Eureka Client** olarak yapılandırır.
    - Bu anotasyon, yalnızca Eureka Server ile çalışmak üzere tasarlanmıştır. Yani, mikroservisinizin Eureka Server'a kaydolmasını ve Eureka Server'dan diğer servisleri keşfetmesini sağlar.
    - Eğer uygulamanız yalnızca Netflix Eureka’yı kullanarak servis keşfi yapmak üzere tasarlanmışsa, bu anotasyon idealdir.

- **Kısıtlama:**
    - Bu anotasyon yalnızca Eureka Server ile çalışır. Eğer sisteminizde başka bir servis keşif aracı (örneğin Consul veya Zookeeper) kullanmayı planlıyorsanız, bu anotasyon işlevsel olmayacaktır.

### 2. **@EnableDiscoveryClient**
- **Özellikler:**
    - `@EnableDiscoveryClient`, Spring Cloud uygulamanızı genel bir servis keşfi istemcisi (Discovery Client) olarak yapılandırır.
    - Bu anotasyon, **Eureka, Consul, Zookeeper** gibi farklı servis keşif araçlarıyla çalışabilir. Spring Cloud ekosisteminde desteklenen herhangi bir servis keşif aracıyla uyumlu çalışır.
    - Eğer servis keşif mekanizmanız zaman içinde değişebilir veya farklı servis keşif araçlarını desteklemek istiyorsanız, bu anotasyon daha esnek bir çözümdür.

- **Esneklik:**
    - `@EnableDiscoveryClient`, Eureka dışında farklı servis keşif mekanizmalarını desteklediği için daha esnektir. Örneğin, uygulamanız başlangıçta Eureka kullanıyor olabilir, ancak gelecekte Consul veya Zookeeper’a geçmeyi planlıyorsanız, `@EnableDiscoveryClient` kullanmanız daha mantıklı olacaktır.

### Özet:
- **`@EnableEurekaClient`:** Sadece Eureka Server ile çalışır. Eureka’ya özgü bir yapılandırma gerektiren durumlarda kullanılır.
- **`@EnableDiscoveryClient`:** Eureka, Consul, Zookeeper gibi farklı servis keşif araçlarıyla çalışabilir. Daha esnek ve çoklu servis keşif desteği sunar.

### Hangi Durumda Hangisi Kullanılır?
- **Eureka’ya Bağlı:** Eğer sisteminiz sadece Eureka Server kullanıyorsa ve başka bir servis keşif aracına geçmeyi düşünmüyorsanız, `@EnableEurekaClient` anotasyonu yeterlidir.
- **Esneklik Gereksinimi:** Eğer sisteminizde farklı servis keşif araçları kullanmayı planlıyorsanız veya gelecekte servis keşif çözümünü değiştirme ihtiyacı olabileceğini düşünüyorsanız, `@EnableDiscoveryClient` anotasyonu daha uygun olacaktır.

Bu iki anotasyon arasında seçim yaparken, uygulamanızın mevcut ve gelecekteki ihtiyaçlarını göz önünde bulundurmalısınız.