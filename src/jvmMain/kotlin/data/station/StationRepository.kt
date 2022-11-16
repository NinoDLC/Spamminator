package data.station

import data.station.model.StationEntity

class StationRepository {

    companion object {
        private val stations = listOf(
            StationEntity(
                id = "1",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/c741cdb1-7a5c-4f82-b088-2ba577b2be1d/264x168-noTransform_logocentertransparent_franceinter_v2.png",
                name = "Inter",
                color = 0xffe20134,
                liveRule = "apprf_inter_player"
            ),
            StationEntity(
                id = "2",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2021/02/6c70e097-da15-4450-a802-9fc25fc6bb34/264x168-noTransform_logocentertransparent_franceinfo.png",
                name = "Info",
                color = 0xff323232,
                liveRule = "apprf_info_player"
            ),
            StationEntity(
                id = "7",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/21428c37-c85f-4f23-9063-f0490b55a644/264x168-noTransform_logocentertransparent_fip_v2.png",
                name = "Fip",
                color = 0xffe2007a,
                liveRule = "apprf_fip_player"
            ),
            StationEntity(
                id = "64",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/21428c37-c85f-4f23-9063-f0490b55a644/264x168-noTransform_logocentertransparent_fip_v2.png",
                name = "Rock",
                color = 0xfff93446,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "65",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/21428c37-c85f-4f23-9063-f0490b55a644/264x168-noTransform_logocentertransparent_fip_v2.png",
                name = "Jazz",
                color = 0xff13898d,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "66",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/21428c37-c85f-4f23-9063-f0490b55a644/264x168-noTransform_logocentertransparent_fip_v2.png",
                name = "Groove",
                color = 0xff8664ee,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "74",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/21428c37-c85f-4f23-9063-f0490b55a644/264x168-noTransform_logocentertransparent_fip_v2.png",
                name = "Electro",
                color = 0xff00d3ff,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "78",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/21428c37-c85f-4f23-9063-f0490b55a644/264x168-noTransform_logocentertransparent_fip_v2.png",
                name = "Pop",
                color = 0xff25d362,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "69",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/21428c37-c85f-4f23-9063-f0490b55a644/264x168-noTransform_logocentertransparent_fip_v2.png",
                name = "Monde",
                color = 0xffefa439,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "71",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/21428c37-c85f-4f23-9063-f0490b55a644/264x168-noTransform_logocentertransparent_fip_v2.png",
                name = "Reggae",
                color = 0xff477442,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "70",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/21428c37-c85f-4f23-9063-f0490b55a644/264x168-noTransform_logocentertransparent_fip_v2.png",
                name = "Nouveau",
                color = 0xff357ded,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "77",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/21428c37-c85f-4f23-9063-f0490b55a644/264x168-noTransform_logocentertransparent_fip_v2.png",
                name = "Metal",
                color = 0xff504274,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "95",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/21428c37-c85f-4f23-9063-f0490b55a644/264x168-noTransform_logocentertransparent_fip_v2.png",
                name = "Hip-Hop",
                color = 0xffBFC61D,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "5",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/6b02540a-9d91-4ba4-8f6b-71661af2e7b4/264x168-noTransform_logocentertransparent_franceculture_v2.png",
                name = "Culture",
                color = 0xff762b84,
                liveRule = "apprf_culture_player"
            ),
            StationEntity(
                id = "11",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "RCFM",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "12",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Alsace",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "13",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Armorique",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "14",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Auxerre",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "15",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Béarn Bigorre",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "16",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Belfort-Montbéliard",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "17",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Berry",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "18",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Besançon",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "19",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Bourgogne",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "20",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Breizh Izel",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "21",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Champagne-Ardenne",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "22",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Cotentin",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "23",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Creuse",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "24",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Drôme Ardèche",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "25",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Gard Lozère",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "26",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Gascogne",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "27",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Gironde",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "28",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Hérault",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "29",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Isère",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "30",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "La Rochelle",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "31",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Limousin",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "32",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Loire Océan",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "33",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Sud Lorraine",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "34",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Mayenne",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "36",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Nord",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "37",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Normandie (Calvados - Orne)",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "38",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Normandie (Seine-Maritime - Eure)",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "39",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Orléans",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "40",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Pays d'Auvergne",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "41",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Pays Basque",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "42",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Pays de Savoie",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "43",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Périgord",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "44",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Picardie",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "45",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Provence",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "46",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Roussillon",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "47",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Touraine",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "48",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Vaucluse",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "49",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Azur",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "50",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Lorraine Nord",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "54",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Poitou",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "56",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Bleu",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "68",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Paris",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "90",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Elsass",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "91",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Maine",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "92",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Occitanie",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "93",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/b8dc35d3-3011-4746-84f5-cd011a858be3/264x168-noTransform_logocentertransparent_francebleu_v2.png",
                name = "Saint-Étienne Loire",
                color = 0xff0078d7,
                liveRule = "apprf_bleu_player"
            ),
            StationEntity(
                id = "4",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/c074ac25-0442-4a24-a999-e26c8f27db1d/264x168-noTransform_logocentertransparent_francemusique_v2.png",
                name = "Musique",
                color = 0xffa90042,
                liveRule = "apprf_musique_player"
            ),
            StationEntity(
                id = "401",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/c074ac25-0442-4a24-a999-e26c8f27db1d/264x168-noTransform_logocentertransparent_francemusique_v2.png",
                name = "Easy",
                color = 0xfff9b001,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "409",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/c074ac25-0442-4a24-a999-e26c8f27db1d/264x168-noTransform_logocentertransparent_francemusique_v2.png",
                name = "Opéra",
                color = 0xffe81208,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "408",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/c074ac25-0442-4a24-a999-e26c8f27db1d/264x168-noTransform_logocentertransparent_francemusique_v2.png",
                name = "Baroque",
                color = 0xff007259,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "402",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/c074ac25-0442-4a24-a999-e26c8f27db1d/264x168-noTransform_logocentertransparent_francemusique_v2.png",
                name = "Plus",
                color = 0xffe1672c,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "403",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/c074ac25-0442-4a24-a999-e26c8f27db1d/264x168-noTransform_logocentertransparent_francemusique_v2.png",
                name = "Concerts",
                color = 0xffe50075,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "405",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/c074ac25-0442-4a24-a999-e26c8f27db1d/264x168-noTransform_logocentertransparent_francemusique_v2.png",
                name = "Jazz",
                color = 0xff293784,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "406",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/c074ac25-0442-4a24-a999-e26c8f27db1d/264x168-noTransform_logocentertransparent_francemusique_v2.png",
                name = "Contemporaine",
                color = 0xff028fcf,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "404",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/c074ac25-0442-4a24-a999-e26c8f27db1d/264x168-noTransform_logocentertransparent_francemusique_v2.png",
                name = "Ocora",
                color = 0xff78b22a,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "407",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/c074ac25-0442-4a24-a999-e26c8f27db1d/264x168-noTransform_logocentertransparent_francemusique_v2.png",
                name = "La B.O. …",
                color = 0xff8c7ebb,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "6",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/df544db8-d1cf-4261-83ba-12059eea65cc/264x168-noTransform_logocentertransparent_mouv_v2.png",
                name = "Mouv",
                color = 0xff33332f,
                liveRule = "apprf_mouv_player"
            ),
            StationEntity(
                id = "605",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/df544db8-d1cf-4261-83ba-12059eea65cc/264x168-noTransform_logocentertransparent_mouv_v2.png",
                name = "Rap FR",
                color = 0xff1a2661,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "75",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/df544db8-d1cf-4261-83ba-12059eea65cc/264x168-noTransform_logocentertransparent_mouv_v2.png",
                name = "100% Mix",
                color = 0xff42efcd,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "601",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/df544db8-d1cf-4261-83ba-12059eea65cc/264x168-noTransform_logocentertransparent_mouv_v2.png",
                name = "Classics",
                color = 0xffa78d00,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "606",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/df544db8-d1cf-4261-83ba-12059eea65cc/264x168-noTransform_logocentertransparent_mouv_v2.png",
                name = "Kids'N…",
                color = 0xff481590,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "604",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/df544db8-d1cf-4261-83ba-12059eea65cc/264x168-noTransform_logocentertransparent_mouv_v2.png",
                name = "Rap US",
                color = 0xffef413d,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "603",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/df544db8-d1cf-4261-83ba-12059eea65cc/264x168-noTransform_logocentertransparent_mouv_v2.png",
                name = "R'n'B",
                color = 0xffc1125d,
                liveRule = "apprf_webradio_common_player"
            ),
            StationEntity(
                id = "602",
                icon = "https://www.radiofrance.fr/s3/cruiser-production/2022/05/df544db8-d1cf-4261-83ba-12059eea65cc/264x168-noTransform_logocentertransparent_mouv_v2.png",
                name = "Dancehall",
                color = 0xff009667,
                liveRule = "apprf_webradio_common_player"
            ),
        )
    }

    fun getStationEntity(stationId: String): StationEntity {
        return stations.find { it.id == stationId } ?: throw UnsupportedOperationException("Unknown stationId = $stationId")
    }
}