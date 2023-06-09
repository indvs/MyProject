# Android приложения заметок
## Введение
Android приложения заметок, которое позволяет пользователю создавать, просматривать, редактировать и удалять заметки. Приложение имеет экран логина, который использует Firebase для аутентификации пользователей, а также экран просмотра, добавления и редактирования заметок, где для хранения записей используется SQLite.

## Требования
Для запуска приложения необходимо устройство с Android версии 8.0 и выше.

## Установка
Чтобы установить приложение, следуйте инструкциям ниже:

1. Склонируйте репозиторий на свой компьютер: ```git clone https://github.com/halp3ars/ContestAppStudy.git```
2. Откройте проект в Android Studio.
3. Подключите устройство к компьютеру с помощью USB-кабеля или запустите эмулятор Android.
4. Нажмите кнопку "Run" в Android Studio, чтобы установить приложение на устройство или эмулятор.
ИЛИ
1. Скачать APK файл
2. Установить 


### Данные для тестов
1. Логин test@test.test Пароль 123456
2. Логин test@myaccount.com Пароль testtest

## Использование
### Экран логина
При запуске приложения пользователь увидит экран логина. Если у пользователя уже есть учетная запись Firebase, он может войти в систему, введя свой адрес электронной почты и пароль. После успешной аутентификации пользователь будет перенаправлен на экран просмотра

### Экран просмотра заметок
Экран просмотра заметок позволяет пользователю просматривать, добавлять, редактировать и удалять заметки.

Пользователь может просматривать список заметок, отсортированных по дате добавления. Для добавления новой заметки пользователь может нажать на кнопку "Добавить заметку" в правом нижнем углу. Для редактирования или удаления заметки пользователь может выбрать заметку из списка и нажать и перейти к ней.

### Хранение заметок
Заметки хранятся в локальной базе данных SQLite. Каждая заметка содержит заголовок, текст и дату добавления.

## Развитие приложения
В будущем приложение может быть модернизировано с использованием Firebase Cloud Firestore вместо SQLite для хранения заметок. Это позволит улучшить масштабируемость и производительность приложения, а также добавить возможность синхронизации заметок между устройствами.
