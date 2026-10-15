package com.example.data

import com.example.model.BeatlesAlbum
import com.example.model.BeatlesFact
import com.example.model.BeatlesMember
import com.example.model.FactCategory
import com.example.model.QuizQuestion
import com.example.model.SoundPreset

object BeatlesDataRepository {

  val facts: List<BeatlesFact> = listOf(
    BeatlesFact(
      id = "fact_dentist_lsd",
      title = "Дантист, который тайно подсыпал им ЛСД",
      category = FactCategory.SCANDAL,
      summary = "В 1965 году зубной врач Джон Райли подсыпал наркотик в кофе Джону, Джорджу и их женам на званом ужине.",
      fullStory = "Весной 1965 года лондонский стоматолог Джон Райли пригласил к себе на ужин Джона Леннона с женой Синтией и Джорджа Харрисона с Патти Бойд. После десерта он тайно добавил в кофе кусочки сахара, пропитанные ЛСД. Когда музыканты захотели уйти, хозяин предупредил: «Не советую, я подсыпал вам кислоту». Битлы испугались и спешно уехали в ночной клуб. Леннон вспоминал: «Казалось, ресторан объят пламенем, а лифт спускается прямо в преисподнюю! Мы истерически смеялись и не понимали, где верх, а где низ».",
      year = "1965",
      quote = "Мы думали, что сошли с ума прямо в лифте!",
      quoteAuthor = "Джон Леннон",
      coolTag = "Тайный ужин"
    ),
    BeatlesFact(
      id = "fact_blisters_helter_skelter",
      title = "«У меня волдыри на пальцах!» — ярость Ринго",
      category = FactCategory.STUDIO,
      summary = "Крик Ринго Старра в финале песни «Helter Skelter» был совершенно искренним криком боли.",
      fullStory = "Пол Маккартни хотел записать самую тяжелую, шумную и грязную песню на свете, чтобы обогнать The Who. 9 сентября 1968 года группа записывала непрерывные яростные дубли на максимальной громкости усилителей. Запись длилась часами. В конце 18-го дубля Ринго от изнеможения швырнул палочки через всю студию и истошно заорал: «I got blisters on my fingers!». Его руки действительно были в кровавых мозолях. Группа оставила этот дубль и этот вопль в финале пластинки!",
      year = "1968",
      quote = "I got blisters on my fingers!",
      quoteAuthor = "Рingo Starr",
      coolTag = "Рок-экстрим"
    ),
    BeatlesFact(
      id = "fact_hard_days_night_chord",
      title = "Загадка аккорда, которую разгадывали 40 лет",
      category = FactCategory.STUDIO,
      summary = "Вступительный удар в «A Hard Day's Night» не мог повторить ни один гитарист в мире до математического анализа 2004 года.",
      fullStory = "С 1964 года музыканты спорили, что за аккорд звучит в первые 2 секунды трека. Тайна раскрылась лишь в 2004 году благодаря математику Джейсону Брауну, применившему преобразование Фурье: это был не один инструмент! Одновременно прозвучали: 12-струнная гитара Rickenbacker Джорджа (Fadd9), 6-струнная акустика Джона, бас Пола на ноте Ре и фортепианный аккорд продюсера Джорджа Мартина. Этот мощный удар стал самым узнаваемым аккордом в истории рока.",
      year = "1964",
      quote = "Мы просто ударили по струнам все вместе, чтобы привлечь внимание!",
      quoteAuthor = "Джордж Харрисон",
      coolTag = "Тайна физики"
    ),
    BeatlesFact(
      id = "fact_naked_abbey_road",
      title = "Репетиция голышом в Abbey Road",
      category = FactCategory.SCANDAL,
      summary = "В аномальную жару 1969 года в лондонской студии сломалась вентиляция, и битлы разделись догола.",
      fullStory = "Летом 1969 года в Лондоне стояла удушающая жара. В знаменитой Studio 2 на Abbey Road кондиционеры не справлялись с раскаленными ламповыми усилителями. Джон Леннон и Пол Маккартни сняли с себя всю одежду, оставив лишь гитары на ремнях, и так играли несколько часов. Звукорежиссеры за стеклом пульта не знали, смеяться им или стесняться, а Йоко Оно наблюдала за происходящим из кровати, установленной прямо посреди студии.",
      year = "1969",
      quote = "В студии было как в духовке, одежда просто прилипала к коже.",
      quoteAuthor = "Джефф Эмерик (звукорежиссер)",
      coolTag = "Жара в студии"
    ),
    BeatlesFact(
      id = "fact_dog_whistle",
      title = "Ультразвуковой свист для собак на Sgt. Pepper",
      category = FactCategory.SECRETS,
      summary = "В конец альбома 1967 года Джон попросил включить частоту 15 кГц, чтобы удивить домашних питомцев.",
      fullStory = "Когда альбом «Sgt. Pepper's Lonely Hearts Club Band» подходит к концу, звучит гигантский финальный фортепианный аккорд «A Day in the Life». После него Джон Леннон настоял на записи высокочастотного тона частотой около 15 000 Гц. Человеческое ухо его почти не слышит, но собаки в комнатах слушателей мгновенно настораживали уши и начинали лаять на проигрыватель. Следом шла зацикленная закольцованная белиберда из реверсивных фраз.",
      year = "1967",
      quote = "Давайте подшутим над собаками наших слушателей!",
      quoteAuthor = "Джон Леннон",
      coolTag = "Секретный трек"
    ),
    BeatlesFact(
      id = "fact_abbey_road_beetle",
      title = "Украденный номер белого «Жука»",
      category = FactCategory.LIFESTYLE,
      summary = "Белый Volkswagen Beetle на обложке Abbey Road случайно попал в кадр, а его номера воровали десятки раз.",
      fullStory = "Уличный фотограф Иэн Макмиллан сделал легендарный снимок за 10 минут, стоя на стремянке, пока полиция перекрыла движение. Белый «Жук» с номером LMW 281F принадлежал обычному жителю соседнего дома. После выхода альбома фанаты постоянно скручивали этот номерной знак на память! В 1986 году сам автомобиль был продан на аукционе Sotheby’s за рекордную сумму, а затем выставлен в музее Volkswagen в Германии.",
      year = "1969",
      quote = "Я просто припарковал машину возле дома и ушел на работу...",
      quoteAuthor = "Владелец машины",
      coolTag = "Культовое авто"
    ),
    BeatlesFact(
      id = "fact_vatican_forgiveness",
      title = "Ватикан простил The Beatles через 42 года",
      category = FactCategory.SCANDAL,
      summary = "После фразы «Мы популярнее Иисуса» пластинки сжигали кострами. Но в 2008 году Святой Престол признал величие группы.",
      fullStory = "В 1966 году Джон обронил фразу: «Христианство уйдет. Мы сейчас популярнее Иисуса». В США поднялась буря: радиостанции бойкотировали песни, фанаты Ку-клукс-клана жгли пластинки. Спустя 42 года, в 2008 году, официальная газета Ватикана L’Osservatore Romano опубликовала статью, назвав битлов национальным достоянием и пояснив: «Это было всего лишь хвастовство юных ливерпульских парней из рабочего класса, на которых обрушилась невиданная слава. Их музыка прекрасна».",
      year = "2008",
      quote = "Они оставили нам невероятно искренние и гениальные мелодии.",
      quoteAuthor = "L’Osservatore Romano",
      coolTag = "Прощение века"
    ),
    BeatlesFact(
      id = "fact_scrambled_eggs",
      title = "«Яичница-болтунья, как я люблю твои ножки»",
      category = FactCategory.STUDIO,
      summary = "Мелодия хита «Yesterday» приснилась Полу во сне, а первые рабочие слова были про завтрак.",
      fullStory = "Пол Маккартни проснулся в доме своей девушки Джейн Эшер с готовой мелодией в голове и сначала испугался, что бессознательно украл чужую песню. Целый месяц он напевал ее джазовым музыкантам и друзьям, спрашивая: «Вы слышали это раньше?». Чтобы не забыть ритм, он пел: «Scrambled eggs / Oh my baby how I love your legs / Not as much as I love scrambled eggs» («Яичница-болтунья, о крошка, как я люблю твои ножки...»). Лишь через полгода родилось слово «Yesterday».",
      year = "1965",
      quote = "Scrambled eggs, oh my baby how I love your legs...",
      quoteAuthor = "Пол Маккартни",
      coolTag = "Рождение шедевра"
    ),
    BeatlesFact(
      id = "fact_greek_island",
      title = "Битлы хотели купить греческий остров и жить коммуной",
      category = FactCategory.LIFESTYLE,
      summary = "В 1967 году группа всерьез собиралась основать собственное утопическое государство на острове Лесно.",
      fullStory = "На пике психоделического увлечения Джон Леннон предложил купить необитаемый греческий остров в Эгейском море. План был грандиозным: построить четыре купольных дома для каждого битла, общую студию звукозаписи и закрытый пляж, где они жили бы со своими семьями вдалеке от налогов и назойливой прессы. Британское правительство даже дало добро на обмен валюты, но пока оформлялись бумаги, группа остыла и переключилась на поездку в Индию.",
      year = "1967",
      quote = "Мы собирались стать островитянами и больше ни от кого не зависеть.",
      quoteAuthor = "Джордж Харрисон",
      coolTag = "Утопия"
    ),
    BeatlesFact(
      id = "fact_rooftop_concert",
      title = "Концерт на крыше и 25-летний констебль",
      category = FactCategory.SCANDAL,
      summary = "Их последнее живое выступление длилось всего 42 минуты и закончилось угрозой ареста за шум в полдень.",
      fullStory = "30 января 1969 года The Beatles вышли на ледяную крышу своего офиса на Сэвил-Роу в Лондоне в шубах своих подруг. Звук разносился по всему фешенебельному району, парализовав уличное движение. Бухгалтеры и клерки лезли на соседние крыши. Через 42 минуты приехали двое полицейских во главе с молодым констеблем Рэем Дэггом, грозя надеть наручники на Леннона и Маккартни. Джон завершил сет бессмертной фразой: «Я хотел бы сказать спасибо от имени группы и нас самих, и надеюсь, мы прошли прослушивание!».",
      year = "1969",
      quote = "Надеюсь, мы прошли прослушивание!",
      quoteAuthor = "Джон Леннон",
      coolTag = "Финальный аккорд"
    ),
    BeatlesFact(
      id = "fact_clapton_guitar",
      title = "Как Эрик Клэптон спас «While My Guitar Gently Weeps»",
      category = FactCategory.FAB_FOUR,
      summary = "Пол и Джон не хотели серьезно играть песню Джорджа, пока в студию не пришел посторонний гений.",
      fullStory = "Джордж Харрисон неделями пытался убедить остальных записать его песню, но Джон и Пол зевали и не проявляли энтузиазма. Тогда Джордж позвонил своему другу Эрику Клэптону и попросил приехать в Abbey Road сыграть соло. Клэптон отнекивался: «Никто посторонний не играет на альбомах The Beatles!». Но придя в студию, он всё изменил: почувствовав гостя мирового калибра, битлы моментально собрались, надели лучшие манеры и идеально записали один из величайших рок-треков в истории.",
      year = "1968",
      quote = "Присутствие Эрика заставило их выложиться на 200%.",
      quoteAuthor = "Джордж Харрисон",
      coolTag = "Дружба гигантов"
    ),
    BeatlesFact(
      id = "fact_reverse_tapes",
      title = "Случайная магия реверсивных плёнок",
      category = FactCategory.STUDIO,
      summary = "Джон Леннон открыл обратное звучание пленки, когда пришел домой под кайфом и заправил катушку задом наперёд.",
      fullStory = "Весной 1966 года во время работы над «Rain» Джон вернулся домой на рассвете с черновой записью на бобине. Будучи сильно уставшим и рассеянным, он случайно заправил ленту в магнитофон обратной стороной. Из динамика полились странные, потусторонние звуки. «Боже, это потрясающе!» — закричал Джон. Наутро он прибежал в Abbey Road и заставил инженера запустить вокал и гитару задом наперед, создав революцию в психоделическом роке.",
      year = "1966",
      quote = "Я слушал это с открытым ртом и не верил своим ушам.",
      quoteAuthor = "Джон Леннон",
      coolTag = "Эврика!"
    )
  )

  val albums: List<BeatlesAlbum> = listOf(
    BeatlesAlbum(
      id = "album_please_please_me",
      title = "Please Please Me",
      year = 1963,
      recordedAt = "Abbey Road, Studio 2 (за 9 часов 45 минут!)",
      descriptionRu = "Дебютный взрыв Beatlemania. Почти весь альбом был записан вживую за один изнурительный день, так как у лейбла не было лишних денег на студийное время.",
      innovationRu = "Живая энергия Cavern Club без студийных склеек и наложений.",
      secretFactRu = "Финальную «Twist and Shout» Джон пел с температурой 38°C и сорванным горлом, рассасывая таблетки от кашля, поэтому его голос звучит так бешено и хрипло.",
      primaryColorHex = 0xFFD32F2F,
      secondaryColorHex = 0xFFFFCDD2,
      keyTracks = listOf("I Saw Her Standing There", "Please Please Me", "Love Me Do", "Twist and Shout")
    ),
    BeatlesAlbum(
      id = "album_hard_days_night",
      title = "A Hard Day's Night",
      year = 1964,
      recordedAt = "Abbey Road Studios",
      descriptionRu = "Первый альбом, где абсолютно все треки были написаны исключительно дуэтом Леннон-Маккартни. Саундтрек к их культовому комедийному фильму.",
      innovationRu = "Первое использование 12-струнной гитары Rickenbacker 360/12, определившей звучание фолк-рока.",
      secretFactRu = "Название придумал Ринго: после 14-часовой смены он вышел и вздохнул: «Ух, тяжелый выдался день... (It's been a hard day)», но увидев звезды, добавил: «...’s night!».",
      primaryColorHex = 0xFF1976D2,
      secondaryColorHex = 0xFFBBDEFB,
      keyTracks = listOf("A Hard Day's Night", "Can't Buy Me Love", "And I Love Her", "If I Fell")
    ),
    BeatlesAlbum(
      id = "album_rubber_soul",
      title = "Rubber Soul",
      year = 1965,
      recordedAt = "Abbey Road Studios",
      descriptionRu = "Переломный момент от подросткового поп-рока к глубокой лирике, акустике и сложным студийным аранжировкам.",
      innovationRu = "Первое появление индийского ситара в западной поп-музыке (в треке «Norwegian Wood»).",
      secretFactRu = "Название Rubber Soul («Резиновая душа») — насмешка над белыми музыкантами, пытавшимися копировать черный соул, называя его «plastic soul».",
      primaryColorHex = 0xFFF57C00,
      secondaryColorHex = 0xFFFFE0B2,
      keyTracks = listOf("Norwegian Wood", "Nowhere Man", "In My Life", "Michelle")
    ),
    BeatlesAlbum(
      id = "album_revolver",
      title = "Revolver",
      year = 1966,
      recordedAt = "Abbey Road Studios",
      descriptionRu = "Многие критики считают его лучшим альбомом всех времен. Революция психоделии, лупов, смычковых октетов и восточных ладов.",
      innovationRu = "Изобретение искусственного дабл-трекинга (ADT) и использование реверсивных лент.",
      secretFactRu = "Для песни «Tomorrow Never Knows» Джон просил звукарей: «Сделайте так, чтобы я звучал как далай-лама, поющий с вершины Гималаев». Голос пустили через вращающийся динамик Leslie!",
      primaryColorHex = 0xFF388E3C,
      secondaryColorHex = 0xFFC8E6C9,
      keyTracks = listOf("Eleanor Rigby", "Taxman", "Tomorrow Never Knows", "Yellow Submarine")
    ),
    BeatlesAlbum(
      id = "album_sgt_pepper",
      title = "Sgt. Pepper's Lonely Hearts Club Band",
      year = 1967,
      recordedAt = "Abbey Road Studios",
      descriptionRu = "Культурный триумф эпохи «Лета любви». Концептуальный шедевр, навсегда превративший рок-пластинку в форму высокого искусства.",
      innovationRu = "Прямой переход между треками без пауз и 40-секундный затухающий финальный аккорд.",
      secretFactRu = "Финальный ми-мажорный аккорд «A Day in the Life» играли в 10 рук на трех роялях Джон, Пол, Ринго и Джордж Мартин, выкрутив микрофоны на максимальную чувствительность.",
      primaryColorHex = 0xFF7B1FA2,
      secondaryColorHex = 0xFFE1BEE7,
      keyTracks = listOf("Lucy in the Sky with Diamonds", "A Day in the Life", "With a Little Help from My Friends", "Getting Better")
    ),
    BeatlesAlbum(
      id = "album_white_album",
      title = "The Beatles (White Album)",
      year = 1968,
      recordedAt = "Abbey Road & Trident Studios",
      descriptionRu = "Двойной альбом с кристально белой обложкой. Разнообразие от нежного фолка до дикого прото-метала.",
      innovationRu = "«Helter Skelter» считается первой в истории записью в жанре хеви-метал / прото-панк.",
      secretFactRu = "Каждая копия первой партии винила имела свой собственный выбитый серийный номер. Экземпляр № 0000001, принадлежавший Ринго Старру, продали за $790,000!",
      primaryColorHex = 0xFF455A64,
      secondaryColorHex = 0xFFCFD8DC,
      keyTracks = listOf("While My Guitar Gently Weeps", "Helter Skelter", "Blackbird", "Back in the U.S.S.R.")
    ),
    BeatlesAlbum(
      id = "album_abbey_road",
      title = "Abbey Road",
      year = 1969,
      recordedAt = "Abbey Road Studios",
      descriptionRu = "Лебединая песня группы, записанная на пике мастерства. 16-минутное попурри на второй стороне пластинки стало вершиной гармонии.",
      innovationRu = "Первое широкое использование синтезатора Moog в рок-музыке.",
      secretFactRu = "На обложке Пол идет босиком, не в ногу с остальными и с сигаретой в правой руке (хотя он левша) — это породило мировую теорию заговора «Paul is dead».",
      primaryColorHex = 0xFF00796B,
      secondaryColorHex = 0xFFB2DFDB,
      keyTracks = listOf("Come Together", "Something", "Here Comes the Sun", "Octopus's Garden")
    ),
    BeatlesAlbum(
      id = "album_let_it_be",
      title = "Let It Be",
      year = 1970,
      recordedAt = "Apple Studios & Twickenham Studios",
      descriptionRu = "Последний выпущенный альбом группы. Попытка вернуться к корням рок-н-ролла без студийных трюков под надзором продюсера Фила Спектора.",
      innovationRu = "Живая студийная сессия и запись легендарного концерта на крыше.",
      secretFactRu = "Джон Леннон терпеть не мог богатую оркестровку Спектора в «The Long and Winding Road», но альбом стал историческим финалом эпохи.",
      primaryColorHex = 0xFFE64A19,
      secondaryColorHex = 0xFFFFCCBC,
      keyTracks = listOf("Let It Be", "Get Back", "Across the Universe", "The Long and Winding Road")
    )
  )

  val members: List<BeatlesMember> = listOf(
    BeatlesMember(
      id = "member_john",
      name = "Джон Леннон",
      nicknameRu = "The Smart Beatle (Умник и бунтарь)",
      roleRu = "Ритм-гитара, клавишные, губная гармоника, вокал",
      instrumentsRu = "Rickenbacker 325, Epiphone Casino, Gibson J-160E",
      bioHighlightRu = "Сердце бунта и остроумия группы. Автор самых сюрреалистичных текстов и философских гимнов эпохи.",
      quirkyFactRu = "Джон был чудовищно близорук, но годами отказывался носить очки на публике, боясь выглядеть не круто, пока на съемках в Испании не примерил знаменитые круглые «бабушкины» очки.",
      famousQuoteRu = "Жизнь — это то, что происходит с тобой, пока ты оживленно строишь другие планы.",
      iconBadge = "👓",
      signatureColorHex = 0xFFFF5722
    ),
    BeatlesMember(
      id = "member_paul",
      name = "Пол Маккартни",
      nicknameRu = "The Cute Beatle (Обаятельный перфекционист)",
      roleRu = "Бас-гитара, фортепиано, акустика, ударные, вокал",
      instrumentsRu = "Höfner 500/1 Violin Bass, Rickenbacker 4001S, Martin D-28",
      bioHighlightRu = "Неиссякаемый генератор мелодий. Автор «Yesterday», «Hey Jude» и вдохновитель концепции «Sgt. Pepper».",
      quirkyFactRu = "Пол выбрал бас Höfner именно потому, что он симметричный в форме скрипки: для Пола-левши он смотрелся ровно и не выглядел перевернутым!",
      famousQuoteRu = "И в конце концов, любовь, которую ты получаешь, равна любви, которую ты отдаешь.",
      iconBadge = "🎻",
      signatureColorHex = 0xFF2196F3
    ),
    BeatlesMember(
      id = "member_george",
      name = "Джордж Харрисон",
      nicknameRu = "The Quiet Beatle (Тихий мистик)",
      roleRu = "Соло-гитара, ситар, вокал, автор песен",
      instrumentsRu = "Gretsch Duo Jet, Fender Stratocaster 'Rocky', Gibson Les Paul 'Lucy'",
      bioHighlightRu = "Младший из четверки. Открыл для рок-музыки индийскую философию, медитацию и создал нестареющие «Something» и «Here Comes the Sun».",
      quirkyFactRu = "В 1958 году Пол привел 15-летнего Джорджа на прослушивание к Джону прямо на верхнем этаже ливерпульского двухэтажного автобуса, где Джордж безупречно сыграл инструментал «Raunchy».",
      famousQuoteRu = "Все вещи должны пройти... рассвет всегда побеждает тьму.",
      iconBadge = "🪕",
      signatureColorHex = 0xFF4CAF50
    ),
    BeatlesMember(
      id = "member_ringo",
      name = "Ринго Старр",
      nicknameRu = "The Funny Beatle (Человек-метроном)",
      roleRu = "Ударные, перкуссия, вокал",
      instrumentsRu = "Ludwig Black Oyster Pearl Drum Kit",
      bioHighlightRu = "Неповторимый грув и человеческое тепло, скреплявшее группу. Его партии барабанов изучают во всех академиях мира.",
      quirkyFactRu = "Ринго — левша, игравший на барабанной установке, собранной для правши! Именно поэтому его сбивки (fills) всегда начинались с нетипичной руки и звучали абсолютно уникально.",
      famousQuoteRu = "Мир и Любовь (Peace and Love)! Я просто парень, который любит стучать в барабаны.",
      iconBadge = "🥁",
      signatureColorHex = 0xFFFFC107
    )
  )

  val soundPresets: List<SoundPreset> = listOf(
    SoundPreset(
      id = "sound_hard_days_night",
      title = "Таинственный Fadd9 Аккорд",
      subtitle = "A Hard Day's Night (1964)",
      description = "Тот самый легендарный звук открытия трека! Резонансный сложный аккорд с гармониками 12-струнного Rickenbacker и басового тона.",
      iconName = "Bolt",
      durationMs = 2800
    ),
    SoundPreset(
      id = "sound_let_it_be_piano",
      title = "Теплый мажорный рояль",
      subtitle = "Let It Be (1970)",
      description = "Успокаивающий резонансный C-Major аккорд винтажного фортепиано Blüthner из студии Abbey Road.",
      iconName = "Piano",
      durationMs = 2500
    ),
    SoundPreset(
      id = "sound_sitar_drone",
      title = "Ситаровый дрон Харрисона",
      subtitle = "Norwegian Wood (1965)",
      description = "Восточный гудящий звук ситара с обертонами, который Джордж впервые записал на рок-пластинке.",
      iconName = "SelfImprovement",
      durationMs = 3200
    ),
    SoundPreset(
      id = "sound_rooftop_rock",
      title = "Грязный рифф на крыше",
      subtitle = "Get Back (1969)",
      description = "Плотный рок-н-ролльный блюзовый аккорд с ламповым овердрайвом Epiphone Casino Джона Леннона.",
      iconName = "ElectricGuitar",
      durationMs = 2200
    ),
    SoundPreset(
      id = "sound_dog_whistle",
      title = "Свист для собак (15 кГц)",
      subtitle = "Sgt. Pepper (1967)",
      description = "Ультразвуковой писк 15 000 Гц, добавленный битлами в конец винила для домашних питомцев!",
      iconName = "Pets",
      durationMs = 1800
    ),
    SoundPreset(
      id = "sound_submarine_sonar",
      title = "Сонар Жёлтой Подлодки",
      subtitle = "Yellow Submarine (1966)",
      description = "Акустический звонкий подводный эхо-импульс со звуковыми пузырьками студии Abbey Road.",
      iconName = "WaterDrop",
      durationMs = 2400
    )
  )

  val quizQuestions: List<QuizQuestion> = listOf(
    QuizQuestion(
      id = 1,
      questionRu = "Какое было первоначальное рабочее название у суперхита «Yesterday»?",
      optionsRu = listOf(
        "Scrambled Eggs («Яичница-болтунья»)",
        "Lonely Sunday («Одинокое воскресенье»)",
        "Ham and Cheese («Ветчина и сыр»)",
        "Wake Up Baby («Проснись, детка»)"
      ),
      correctOptionIndex = 0,
      explanationRu = "Пол сочинил мелодию во сне и, пока не придумал слова, напевал: «Scrambled eggs, oh my baby how I love your legs!»."
    ),
    QuizQuestion(
      id = 2,
      questionRu = "Кто из рок-гигантов сыграл знаменитое гитарное соло в «While My Guitar Gently Weeps»?",
      optionsRu = listOf(
        "Джими Хендрикс",
        "Эрик Клэптон",
        "Джимми Пейдж",
        "Кит Ричардс"
      ),
      correctOptionIndex = 1,
      explanationRu = "Джордж Харрисон пригласил своего близкого друга Эрика Клэптона, чтобы примирить разругавшихся битлов во время сессий Белого Альбома."
    ),
    QuizQuestion(
      id = 3,
      questionRu = "Сколько длился последний публичный концерт The Beatles на крыше Apple Corps?",
      optionsRu = listOf(
        "Ровно 15 минут",
        "42 минуты",
        "3 часа",
        "Всего один куплет"
      ),
      correctOptionIndex = 1,
      explanationRu = "Концерт длился 42 минуты в холодный полдень 30 января 1969 года, пока лондонская полиция не потребовала выключить усилители."
    ),
    QuizQuestion(
      id = 4,
      questionRu = "Что Ринго Старр истошно кричит в самом финале трека «Helter Skelter»?",
      optionsRu = listOf(
        "«I love you all!»",
        "«Turn off the lights!»",
        "«I've got blisters on my fingers!»",
        "«We are the champions!»"
      ),
      correctOptionIndex = 2,
      explanationRu = "После 18 бешеных дублей на барабанах пальцы Ринго покрылись волдырями, и он в ярости закричал от боли, швырнув палочки."
    ),
    QuizQuestion(
      id = 5,
      questionRu = "Почему на культовой обложке Abbey Road Пол Маккартни идет босиком?",
      optionsRu = listOf(
        "Это был скрытый оккультный шифр",
        "Ему просто жали новые туфли",
        "Он забыл обувь в студии",
        "Так потребовал дорожный патруль"
      ),
      correctOptionIndex = 1,
      explanationRu = "В Лондоне было очень жарко. Пол пришел на съемку в сандалиях, но они натирали, поэтому он скинул их и пошел босиком по теплому асфальту!"
    ),
    QuizQuestion(
      id = 6,
      questionRu = "За сколько времени The Beatles записали практически весь свой первый альбом «Please Please Me»?",
      optionsRu = listOf(
        "За 6 месяцев",
        "За 3 недели",
        "Менее чем за 10 часов (в один день)",
        "За 2 часа"
      ),
      correctOptionIndex = 2,
      explanationRu = "11 февраля 1963 года группа пришла в студию в 10:00 утра и к 22:45 вечера завершила 10 песен, потратив всего 9 часов 45 минут!"
    ),
    QuizQuestion(
      id = 7,
      questionRu = "Какой необычный звук Джон Леннон попросил включить в конец альбома Sgt. Pepper?",
      optionsRu = listOf(
        "Мяуканье кота",
        "Свист на частоте 15 кГц для собак",
        "Звук работающей газонокосилки",
        "Шум взлетающего самолета"
      ),
      correctOptionIndex = 1,
      explanationRu = "Джон захотел пошутить над питомцами слушателей и добавил ультразвуковой тон 15 кГц, который слышат собаки, но почти не различают люди."
    ),
    QuizQuestion(
      id = 8,
      questionRu = "Какую фразу сказал Джон Леннон в микрофон, когда полицейские остановили концерт на крыше?",
      optionsRu = listOf(
        "«Рок-н-ролл мертв!»",
        "«Лондон, вы лучшие!»",
        "«Надеюсь, мы прошли прослушивание!»",
        "«Встретимся в суде!»"
      ),
      correctOptionIndex = 2,
      explanationRu = "Джон остроумно пошутил: «I'd like to say thank you on behalf of the group and ourselves, and I hope we've passed the audition!»."
    )
  )
}
