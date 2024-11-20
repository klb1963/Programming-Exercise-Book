Проект "Обменный пункт валюты"

Описание проекта:
Разработать консольное приложение для имитации работы обменного пункта валюты.
Пользователи могут:
регистрировать аккаунты,
открывать счета в различных валютах (в приложении должна быть поддержка минимум 3 валют),
пополнять счета,
снимать средства со счетов,
закрывать счета,
осуществлять обмен валюты (например, перевод с EUR счета на USD счет с конвертацией по курсу),
а также просматривать историю своих операций.
Техническое задание:
Многослойная архитектура приложения:
Модель (Model): Определить сущности, такие как пользователь, аккаунт, операция, валюта, курс валюты и / или другие необходимые объекты.
Сервис (Service): Разработать бизнес-логику приложения, включая управление данными пользователей, выполнение валютных операций и т.д.
Репозиторий (Repository): Создать слой для взаимодействия с хранилищем данных (например, в памяти или файле(-ах)).
Организация данных и управление аккаунтами:
Реализовать механизмы для управления данными пользователя, включая их аккаунты и ведение счетов.
У пользователя могут быть счета минимум в 3 разных валютах.
Управление валютными операциями:
Обеспечить функциональность для осуществления валютных операций, включая пополнение, обмен и просмотр истории операций.
Валидация данных:
При регистрации нового пользователя реализовать валидацию введенного email и пароля. Валидация должна убедиться, что email соответствует стандартному формату электронной почты, а пароль соответствует заданным критериям безопасности (например, минимальная длина, наличие букв и цифр).
Пользовательский интерфейс:
Реализовать консольное меню для доступа к функциональности приложения.
Тестирование:
Разработать JUnit тесты для проверки всех аспектов функциональности приложения, особое внимание уделить тестированию сервисного слоя.
Использование коллекции Map:
В процессе разработки приложения активно использовать коллекцию Map для организации и управления данными, такими как учетные записи пользователей, счета, курсы валют и другие подходящие сценарии.
Например:
Для хранения списка аккаунтов пользователя, где ключом будет идентификатор пользователя, а значением - список его аккаунтов.
Для хранения курсов валют, где ключом будет код валюты, а значением - текущий курс.
Для хранения списка пользователей, где ключом будет id, а значением - пользователь.
Разделение функциональности по ролям
Пользователь с ролью администратор может, например:
Менять курс валюты
Изменять роль пользователя
Просматривать историю операций пользователей (опционально)
Блокировать пользователя (опционально)
Исключения:
В случае невозможности выполнить запрашиваемую пользователем операцию, должно быть выброшено соответсвующее исключение (обработать в слое view и выдать сообщение о природе ошибки пользователю)
В случае провала валидации, приложение должно выбрасывать исключение, которое затем должно быть корректно обработано. Это может включать информирование пользователя о причине ошибки и предложение повторить попытку ввода данных.
Опционально:
Возможность сохранения и загрузки данных пользователя (запись / чтение в файл(-ы).
Функционал для просмотра исторических курсов валют (посмотреть историю изменения курса валюты)
Снятие комиссии при каждом переводе
Пользователь может посмотреть историю своих операций
Администратор может посмотреть историю операцию пользователя
Администратор может посмотреть остаток на счетах пользователя
Администратор может заблокировать пользователя - (лишить его возможности совершать операции)