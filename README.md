# Weather Application

Weather Service API, şehir adı ile güncel hava durumunu öğrenmenizi sağlar.

## Uygulama Nasıl Çalışır?

1. Uygulama, `{city}` değişkeni ile `/v1/api/open-weather/{city}` URL'si aracılığıyla istenen şehrin hava durumunu alır.

2. Şehir parametresi için doğrulama yapılır; şehir değeri ondalık veya boş bir değer olamaz.

3. Şehir değeri geçerli değilse, API 400 - HTTP Bad Request yanıtını döndürür.

4. Güncel hava durumu, API_KEY ile veritabanından veya WeatherStack API'den alınabilir.

5. Şehir değeri için en son verinin 30 dakikadan daha eski olmadığından eminse, veri veritabanından alınır.

6. Şehir veritabanında yoksa veya veritabanında 30 dakikadan daha eskiyse, WeatherStack API'ye bir istek gönderilir ve sonuç önbelleğe alınır.

7. Önbellekte anahtar olarak şehir filtresi olan bir değer varsa yanıt doğrudan önbellekten döndürülür.

## Yapılandırma

`WEATHER_STACK_API_KEY`'i `.env` dosyasında tanımlayabilirsiniz.

## Kullanılan Teknolojiler

- Java 17
- Spring Boot 3.0.50
- OpenAPI
- Spring Data JPA
- H2 In Memory Veritabanı
- RESTful API
- Maven
- Docker
- Docker Compose
- Prometheus
- Grafana

## Gereksinimler

- Maven veya Docker

## Docker ile Çalıştırma

Uygulama, Docker motorunu kullanarak oluşturulabilir ve çalıştırılabilir. Docker dosyası çoklu aşamalı bir yapıya sahiptir, bu nedenle ayrı ayrı oluşturmanıza ve çalıştırmanıza gerek yoktur.

Lütfen Docker Compose ile uygulamayı oluşturmak ve çalıştırmak için aşağıdaki adımları izleyin:

```shell
$ cd weather
$ docker-compose up -d
```

Docker Compose, uygulamanın 9595-9597 port aralığındaki 3 kopyasını oluşturur.
#### OpenAPI UI'ye `http://{HOST}:{9595-9597}/swagger-ui.html` adresinden erişebilirsiniz.

### Prometheus
#### Prometheus'a `http://{HOST}:9090` adresinden erişebilirsiniz.
### Grafana
#### Grafana'ya `http://{HOST}:3000` adresinden erişebilirsiniz. - Kullanıcı adı ve şifre "admin" 

---
Kaynak : https://github.com/folksdev


