package com.legp.totalplaytest.mvp.model.response

class BankReferencesModel(
    var status: Int,
    var arrayReferences: ArrayList<BankModel>
)


class BankModel(
    var aliasbank: String,
    var reference: String,
    var bank: String,
    var images: ArrayList<ImagesModel>
)


class ImagesModel(
    var url3X3: String?,
    var url4X4: String?,
    var url5X5: String?
)