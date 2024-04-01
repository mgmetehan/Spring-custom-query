# Spring-custom-query

1. **JPA (Java Persistence API)**:
    - JPA, Java uygulamalarinda iliskisel verileri yonetmek icin bir Java spesifikasyonudur.
    - Gelistiricilere Java nesnelerinin nasil veritabani tablolarina ve tersine eslenmis olacagini tanimlamak icin bir dizi arabirim ve isaretlemeyi saglar.
    - JPA, farkli veritabani yonetim sistemleriyle (DBMS) etkilesim detaylarini soyutlar ve CRUD (Create, Read, Update, Delete) islemlerini gerceklestirmek icin tutarli bir API sunar.
    - Gelistiricilere, veritabaninda depolanan verileri temsil eden Java nesneleri olan varliklarla calisma imkani sunar.
    - https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

2. **JPQL (Java Persistence Query Language)**:
    - JPQL, JPA tarafindan saglanan bir sorgu dilidir ve entity kullanarak veritabani sorgularini gerceklestirmek icin kullanilir.
    - SQL'e (Structured Query Language) benzer ancak database tablolari yerine entity uzerinde calisir.
    - JPQL sorgulari, platformdan bagimsiz bir sekilde yazilir ve gelistiricilere temel veritabani sozdiziminden bagimsiz olarak sorgu yazma imkani saglar.
    - JPQL sorgulari, calisma zamaninda JPA saglayicisi tarafindan yerel SQL sorgularina cevrilir ve gelistiricilere nesne tabanli bir sekilde veritabani sorgulari yazma imkani saglar.

3. **Native Sorgu**:
    - Bir native query, temel veritabani tarafindan desteklenen yerel sorgu dilinde yazilan bir SQL sorgusudur.
    - JPQL sorgularinin aksine, native sorgular kullanilan veritabanina ozgudur ve farkli veritabani yonetim sistemleri arasinda tasinabilir olmayabilir.
    - Native sorgular, gelistiricilerin ozellikle veritabaniyla ilgili ozellikleri kullanmalari veya karmasik sorgulari SQL dilinde dogrudan yazarak performansi optimize etmeleri gerektiginde kullanislidir.

* **jpql entityler uzerinden islemler yapar** 
* **nativequery ise direkt veritabani uzerinden islem yapar**