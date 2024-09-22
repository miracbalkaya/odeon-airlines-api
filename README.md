# Odeon Airlines

Odeon Airlines, uçuş arama ve rezervasyon işlemlerini gerçekleştiren bir web uygulamasıdır.

## Başlarken

Bu talimatlar, projenizi yerel makinenizde çalıştırmak için gerekli adımları sağlar.

### Gereksinimler

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL (veya benzeri bir veritabanı)
- Docker (opsiyonel, Docker kullanarak çalıştırmak isterseniz)

### Kurulum

1. Projeyi klonlayın:
    ```sh
    git clone https://github.com/miracbalkaya/odeonAirlines.git
    cd odeonAirlines
    ```

2. Maven bağıml��lıklarını yükleyin:
    ```sh
    mvn clean install
    ```
3. Docker build command:
    ```sh
    docker build -t odeon-airlines .
    ```
4. Docker run command:
    ```sh
   docker compose up
    ```


## API Endpointleri

### Kullanıcılar

- **Kullanıcı Kaydı**
    - **URL:** `/api/users/signup`
    - **Metot:** `POST`
    - **Açıklama:** Yeni bir kullanıcı kaydı oluşturur.
 

- **Kullanıcı Girişi**
    - **URL:** `/api/users/login`
    - **Metot:** `POST`
    - **Açıklama:** Kullanıcı girişi yapar ve JWT token döner.
    - **Örnek İstek:**
        ```json
        {
            "username": "user1",
            "password": "password"
        }
        ```

### Uçuşlar

- **Uçuş Arama**
    - **URL:** `/api/flights/departure`
    - **Metot:** `GET`
    - **Açıklama:** Belirtilen kalkış şehrine göre uçuşları listeler.
    - **Örnek İstek:**
        ```sh
        GET /api/flights/departure?departureCity=Istanbul
        ```
      
- **Uçuş Listeleme(Admin ve Kullanıcı)**
    - **URL:** `/api/flights`
    - **Metot:** `GET`
    - **Açıklama:** Tüm uçuşları listeler.
  

- **Uçuş Ekleme (Sadece Admin)**
    - **URL:** `/api/flights`
    - **Metot:** `POST`
    - **Açıklama:** Yeni bir uçuş ekler.
    - **Örnek İstek:**
        ```json
        {
            "flightCode": "TK123",
            "departureCity": "Istanbul",
            "arrivalCity": "Ankara",
            "departureTime": "2023-10-01T10:00:00",
            "arrivalTime": "2023-10-01T11:00:00"
        }
        ```

### Şehirler

- **Şehir Listesi**
    - **URL:** `/api/cities`
    - **Metot:** `GET`
    - **Açıklama:** Tüm şehirleri listeler.

## Swagger Dokümantasyonu

Swagger arayüzünü kullanarak API'lerinizi test edebilir ve dokümantasyonunu görüntüleyebilirsiniz.

1. Uygulamayı başlattıktan sonra, tarayıcınızda aşağıdaki URL'yi ziyaret edin:
    ```
    http://localhost:8080/swagger-ui/index.html
    ```
   
## Kullanım

1. Uygulamayı başlattıktan sonra, yukarıdaki API uç noktalarını kullanarak uçuş arama ve rezervasyon işlemlerini gerçekleştirebilirsiniz.
2. Postman veya benzeri bir API istemcisi kullanarak API isteklerini test edebilirsiniz.


