# Stock System - Mobile client for server Inventory managment system

# Оглавление

- ## [Скриншоты работы приложения](#скриншоты-работы-приложения-1)
- ## [Ключевой функционал:](#ключевой-функционал-1)
  - ### [Авторизация и регистрация: IMS-auth-api](#авторизация-и-регистрация-ims-auth-api-1)
  - ### [Создание и назначение заданий: IMS-staff-api](#создание-и-назначение-заданий-ims-staff-api-1)
  - ### [Работа со складом: IMS-product-api](#работа-со-складом-ims-product-api-1)
- ## [Архитектура веб-клиента](#Архитектура)
- ## [Используемые технологии](#используемые-технологии-1)
  
# Ключевой функционал
## Авторизация и Регистрация (ims-auth-api) 
### https://github.com/MrPrograMax/ims-authentication-api
Система регистрации является закрытой, и не позволяет регистрироваться людям не из компании.

Для работы доступно 3 роли: admin, manager, worker

Админ регистрирует менеджеров (так же может и работников)

Менеджер имеет право регистрировать только работников

Работники получают логин и пароль от менеджера и не имеют доступа к регистрации.

## Создание и назначение заданий (ims-staff-api) 
### https://github.com/MrPrograMax/ims-staff-api
Admin/manager имеет право создавать задачи, как отложенные, т.е назначить работника для выполнения позже, так и неотложно.

Админ/manager имеет доступ к просмотру всех доступных задач


Работник имеет доступ только к задачам, которые были выданы ему.

Работник подтверждает выполнение задачи и она попадает в архив выполненых.

Задачи бывают как несвязные, т.е. имеют только текстовые описания, так и связные, которые ориентированны на продукты: добавление, удаление со склада (сервис order & supply в ims-product-api)

## Работа со складом (ims-product-api)
### https://github.com/MrPrograMax/ims-product-api
Каждый контейнер (Product) содержит поля: название, количество, описание, местоположения на складе и статуса

Взаимодействие с контейнерами происходит посредством связных задач, описанных выше.

Для админа и менеджеров имеется возможность просмотра всех продуктов. складской работник доступа не емеет.

# Архитектура
Приложение лежит в папке App

В BuildSrc лежат требующиеся для работы зависимости

В директории Core был написан Web-client на Ktor 
```cmd
core/src/main/java/ru/hackathone/core/inventoryapi
```
Автор веб-клиент части https://github.com/lifedaemon-kill (Я), Ux/Ui и логику приложения делал владелец репозитория.

Был использован маштабируемый и расширяемый подход по принципам SOLID.

Clients классы - описывают низкоуровневые обращения get, post, put, delete

Clients-Services - это оболочки над клиентами, для расширения функционала: отлова ошибок и реакции на разные кода ответов сервера, сериализация приходящих json объектов.

Для каждого сервиса и клиента описаны интерфесы и их имплементации.

Для каждого сервиса ims-auth-api и ims-staff-api описан по одину клиенту и одному сервис, ввиду небольшого числа запросов, и сходного функционала.

Для сервиса ims-product-api был разделен функционал на 4 разных клиента ввиду большого числа эндпоинтов и их группировки на product / status / location / category

Для упрощения работы и простоты использования эти сервисы являются полями Union сервиса. что позволяет легко редактировать сервисы и клиентов.

Клиент-сервисы создаются через IoC DI, для последующего использования в App

Так же созданы dto объекты, для requst и response, кастомные исключения.

Так же я написал тесты для всех требующихся эндпоинтов всех трех сервисов. функционал работает корректно.

Директория:
```cmd
core/src/test/java/ru/hackathone/core/inventoryapi
```

# Используемые технологии

- Coroutines
- Decompose
- Jetpack Compose
- Koin
- KotlinX
- Ktor

# Скриншоты работы приложения
## 1. Меню авторизации
![изображение](https://github.com/DmiMukh/StockSystem/assets/124619126/c08ca92c-dfee-41cb-b312-5dd3179c79e5)

## Авторизация работает полностью, если в базе нет данных, то приложение дальше не пускает
![изображение](https://github.com/DmiMukh/StockSystem/assets/124619126/3326de6e-9534-4ab1-a17d-18204d5abe69)


## 2. Настройка хостов сервисов (шестерня на экране авторизации)
![изображение](https://github.com/DmiMukh/StockSystem/assets/124619126/add47b8e-5d32-45ca-ae82-40be133fd411)

## главный экран от лица админа/менеджера 
![изображение](https://github.com/DmiMukh/StockSystem/assets/124619126/e42a17a1-531b-47d3-aa24-1190bb9c3033)

## Задач нет
![изображение](https://github.com/DmiMukh/StockSystem/assets/124619126/01bf68d3-926b-484d-ba1c-c313da887ecc)

## Создание задачи
![изображение](https://github.com/DmiMukh/StockSystem/assets/124619126/27664abf-5e8c-4714-a9a1-545f5551ba4c)

## Проверим список задач
![изображение](https://github.com/DmiMukh/StockSystem/assets/124619126/08d80ece-8a1c-4dbd-b18a-1a902c7c8649)

## Если зажать, ее можно удалить
![изображение](https://github.com/DmiMukh/StockSystem/assets/124619126/f20dd296-2e48-4b3d-a171-3fc3a36b7e69)

## Если просто нажать, то редактировать 
![изображение](https://github.com/DmiMukh/StockSystem/assets/124619126/e937f201-7317-44b3-96fb-42e9f56f78f5)

## Staff отображает работников в системе (у самих работников данный функционал отсутствует)
![изображение](https://github.com/DmiMukh/StockSystem/assets/124619126/93118f80-f1f1-442a-b6f1-f95085260d98)

## Создадим новый аккаунт
![изображение](https://github.com/DmiMukh/StockSystem/assets/124619126/5e20d4d4-bbd1-4b06-a7fc-66141ba1ec47)

![изображение](https://github.com/DmiMukh/StockSystem/assets/124619126/923168eb-2577-46a3-9fe8-6baec419701a)

## Список продуктов 
![изображение](https://github.com/DmiMukh/StockSystem/assets/124619126/2dd9fdd5-8458-431a-a736-19f93baadd82)

## Если нажать по продукту, можно получить дополнительную информацию и изменить ее
![изображение](https://github.com/DmiMukh/StockSystem/assets/124619126/5a2f0c40-4b6d-4e4b-a4d0-00fec4122068)

## Интерфейс работника
![изображение](https://github.com/DmiMukh/StockSystem/assets/124619126/ba65b4bf-98e0-48c8-bf54-7aab29ecd05e)
