# Config Server
[GitHub](https://github.com/nurrbb/offline_microservices/tree/master)

---

## Config Server Nedir?
Config Server, mikroservislerin konfigürasyonlarını merkezi bir noktada yönetmek için kullanılan bir yapıdır.

- Merkezi bir alan üzerinden mikroservislerin yapılandırma dosyalarını dinamik olarak sağlar.
- Mikroservislerin her birinin kendi içerisinde konfigürasyon dosyalarını barındırmasına gerek kalmaz.

---

## Spring Cloud (Config Client)
Config Client, Spring Cloud ekosisteminde Config Server'dan merkezi olarak yönetilen konfigürasyon dosyalarını almak için kullanılan istemci yapısıdır.

- Mikroservisler genellikle **Config Client** olarak yapılandırılır.
- **Config Client**, Config Server'a bağlanarak merkezi olarak yönetilen yapılandırma dosyalarını alır.
- Uygulama, Config Server'a bağlanarak konfigürasyonlarını dinamik olarak yükleyebilir.

---

## Spring Cloud (Config Server)
Spring Cloud Config Server, merkezi bir konfigürasyon yönetim sunucusu olarak görev yapar.

- Bir veya birden fazla mikroservis için yapılandırma dosyalarını merkezi bir noktada barındırır ve sunar.
- Config Server sayesinde konfigürasyonların yönetimi kolaylaşır ve merkezi bir yerden güncellenebilir hale gelir.

---

### Avantajlar
- **Merkezi Yönetim:** Tüm mikroservislerin konfigürasyon dosyalarını tek bir noktadan yönetme imkânı sağlar.
- **Dinamik Güncellemeler:** Config Server üzerinden yapılan değişiklikler, mikroservislere anında iletilebilir.
- **Esneklik ve Verimlilik:** Mikroservislerin bağımsız çalışabilmesine olanak tanır ve yönetimi kolaylaştırır.

---