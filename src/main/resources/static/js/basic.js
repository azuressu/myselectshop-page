* {
    font-family: 'Georgia', serif;
}

body {
    margin: 0px;
}


#search-result-box {
    margin-top: 15px;
}

.search-itemDto {
    width: 530px;
    display: flex;
    flex-direction: row;
    align-content: center;
    justify-content: space-around;
}

.search-itemDto-left img {
    width: 159px;
    height: 159px;
}

.search-itemDto-center {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-evenly;
}

.search-itemDto-center div {
    width: 280px;
    height: 23px;
    font-size: 18px;
    font-weight: normal;
    font-stretch: normal;
    font-style: normal;
    line-height: 1.3;
    letter-spacing: -0.9px;
    text-align: left;
    color: #343a40;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
}

.search-itemDto-center div.price {
    height: 27px;
    font-size: 27px;
    font-weight: 600;
    font-stretch: normal;
    font-style: normal;
    line-height: 1;
    letter-spacing: -0.54px;
    text-align: left;
    color: #E8344E;
}

.search-itemDto-center span.unit {
    width: 17px;
    height: 18px;
    font-size: 18px;
    font-weight: 500;
    font-stretch: normal;
    font-style: normal;
    line-height: 1;
    letter-spacing: -0.9px;
    text-align: center;
    color: #000000;
}

.search-itemDto-right {
    display: inline-block;
    height: 100%;
    vertical-align: middle
}

.search-itemDto-right img {
    height: 25px;
    width: 25px;
    vertical-align: middle;
    margin-top: 60px;
    cursor: pointer;
}

input#query {
    padding: 15px;
    width: 526px;
    border-radius: 2px;
    background-color: #e9ecef;
    border: none;

    background-image: url('../images/icon-search.png');
    background-repeat: no-repeat;
    background-position: right 10px center;
    background-size: 20px 20px;
}

input#query::placeholder {
    padding: 15px;
}

button {
    color: white;
    border-radius: 4px;
    border-radius: none;
}

.popup-container {
    display: none;
    position: fixed;
    top: 0;
    left: 0;
    bottom: 0;
    right: 0;
    background-color: rgba(0, 0, 0, 0.5);
    align-items: center;
    justify-content: center;
}

.popup-container.active {
    display: flex;
}

.popup {
    padding: 20px;
    box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.3);
    position: relative;
    width: 370px;
    height: 209px;
    border-radius: 11px;
    background-color: #ffffff;
}

.popup h1 {
    margin: 0px;
    font-size: 22px;
    font-weight: 500;
    font-stretch: normal;
    font-style: normal;
    line-height: 1;
    letter-spacing: -1.1px;
    color: #000000;
}

.popup input {
    width: 320px;
    height: 22px;
    border-radius: 2px;
    border: solid 1.1px #dee2e6;
    margin-right: 9px;
    margin-bottom: 10px;
    padding-left: 10px;
}

.add-folder-btn {
    width: 330px;
}

.popup button.close {
    position: absolute;
    top: 15px;
    right: 15px;
    color: #adb5bd;
    background-color: #fff;
    font-size: 19px;
    border: none;
}

.popup button.cta {
    width: 369.1px;
    height: 43.9px;
    border-radius: 2px;
    background-color: #15aabf;
    border: none;
}

.popup button.cta2 {
    width: 352.1px;
    height: 43.9px;
    border-radius: 2px;
    background-color: #15aabf;
    border: none;
}

#search-area, #see-area {
    width: 530px;
    margin: auto;
}

.nav {
    width: 530px;
    margin: 30px auto;
    display: flex;
    align-items: center;
    justify-content: space-around;
}

.nav div {
    cursor: pointer;
}

.nav div.active {
    font-weight: 700;
}

.header {
    height: 255px;
    box-sizing: border-box;
    background-color: #15aabf;
    color: white;
    text-align: center;
    padding-top: 80px;
    /*padding: 50px;*/
    font-size: 45px;
    font-weight: bold;
}

#header-title-login-user {
    font-size: 36px;
    letter-spacing: -1.08px;
}

#header-title-select-shop {
    margin-top: 20px;
    font-size: 45px;
    letter-spacing: 1.1px;
}

#product-container {
    grid-template-columns: 100px 50px 100px;
    grid-template-rows: 80px auto 80px;
    column-gap: 10px;
    row-gap: 15px;
}

.product-card {
    width: 300px;
    margin: auto;
    cursor: pointer;
}

.product-card .card-header {
    width: 300px;
}

.product-card .card-header img {
    width: 300px;
}

.product-card .card-body {
    margin-top: 15px;
}

.product-card .card-body .title {
    font-size: 11px;
    font-weight: normal;
    font-stretch: normal;
    font-style: normal;
    line-height: 1;
    letter-spacing: -0.75px;
    text-align: left;
    color: #343a40;
    margin-bottom: 10px;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
}

.product-card .card-body .lprice {
    font-size: 15.8px;
    font-weight: normal;
    font-stretch: normal;
    font-style: normal;
    line-height: 1;
    letter-spacing: -0.79px;
    color: #000000;
    margin-bottom: 10px;
}

.product-card .card-body .lprice span {
    font-size: 13.4px;
    font-weight: 600;
    font-stretch: normal;
    font-style: normal;
    line-height: 1;
    letter-spacing: -0.43px;
    text-align: left;
    color: #E8344E;
}

.product-card .card-body .isgood {
    margin-top: 10px;
    padding: 10px 20px;
    color: white;
    border-radius: 2.6px;
    background-color: #ff8787;
    width: 48px;
}

.pagination {
    font-size: 14px;
    margin-top: 12px;
    margin-left: auto;
    margin-right: auto;
    width: 65%;
}

.folder-active {
    background-color: crimson !important;;
}

.none {
    display: none;
}

.folder-bar {
    width: 100%;
    overflow: hidden;
}

.folder-black, .folder-black:hover {
    color: #fff!important;
    background-color: #000!important;
}

.folder-bar .folder-button {
    white-space: normal;
}
.folder-bar .folder-bar-item {
    font-size: 17px;
    padding: 8px 16px;
    float: left;
    width: auto;
    border: none;
    display: block;
    outline: 0;
}

.folder-btn, .folder-button {
    border: none;
    display: inline-block;
    padding: 8px 16px;
    vertical-align: middle;
    overflow: hidden;
    text-decoration: none;
    color: inherit;
    background-color: inherit;
    text-align: center;
    cursor: pointer;
    white-space: nowrap;
}

#login-form {
    width: 538px;
    height: 710px;
    margin: 70px auto 141px auto;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;
    /*gap: 96px;*/
    padding: 56px 0 0;
    border-radius: 10px;
    box-shadow: 0 4px 25px 0 rgba(0, 0, 0, 0.15);
    background-color: #ffffff;
}

#login-title {
    width: 303px;
    height: 32px;
    /*margin: 56px auto auto auto;*/
    flex-grow: 0;
    font-family: SpoqaHanSansNeo;
    font-size: 32px;
    font-weight: bold;
    font-stretch: normal;
    font-style: normal;
    line-height: 1;
    letter-spacing: -0.96px;
    text-align: left;
    color: #212529;
}

#login-kakao-btn {
    border-width: 0;
    margin: 96px 0 8px;
    width: 393px;
    height: 62px;
    flex-grow: 0;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    gap: 10px;
    /*margin: 0 0 8px;*/
    padding: 11px 12px;
    border-radius: 5px;
    background-color: #ffd43b;

    font-family: SpoqaHanSansNeo;
    font-size: 20px;
    font-weight: bold;
    font-stretch: normal;
    font-style: normal;
    color: #414141;
}

#login-id-btn {
    width: 393px;
    height: 62px;
    flex-grow: 0;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    gap: 10px;
    /*margin: 8px 0 0;*/
    padding: 11px 12px;
    border-radius: 5px;
    border: solid 1px #212529;
    background-color: #ffffff;

    font-family: SpoqaHanSansNeo;
    font-size: 20px;
    font-weight: bold;
    font-stretch: normal;
    font-style: normal;
    color: #414141;
}

.login-input-box {
    border-width: 0;

    width: 370px !important;
    height: 52px;
    margin: 14px 0 0;
    border-radius: 5px;
    background-color: #e9ecef;
}

.login-id-label {
    /*width: 44.1px;*/
    /*height: 16px;*/
    width: 382px;
    padding-left: 11px;
    margin-top: 40px;
    /*margin: 0 337.9px 14px 11px;*/
    font-family: NotoSansCJKKR;
    font-size: 16px;
    font-weight: normal;
    font-stretch: normal;
    font-style: normal;
    line-height: 1;
    letter-spacing: -0.8px;
    text-align: left;
    color: #212529;
}

#login-id-submit {
    border-width: 0;
    width: 393px;
    height: 62px;
    flex-grow: 0;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    gap: 10px;
    margin: 40px 0 0;
    padding: 11px 12px;
    border-radius: 5px;
    background-color: #15aabf;

    font-family: SpoqaHanSansNeo;
    font-size: 20px;
    font-weight: bold;
    font-stretch: normal;
    font-style: normal;
    line-height: 1;
    letter-spacing: normal;
    text-align: center;
    color: #ffffff;
}

#sign-text {
    position:absolute;
    top:48px;
    right:110px;
    font-size: 18px;
    font-family: SpoqaHanSansNeo;
    font-size: 18px;
    font-weight: 500;
    font-stretch: normal;
    font-style: normal;
    line-height: 1;
    letter-spacing: 0.36px;
    text-align: center;
    color: #ffffff;
}

#login-text {
    position:absolute;
    top:48px;
    right:50px;
    font-size: 18px;
    font-family: SpoqaHanSansNeo;
    font-size: 18px;
    font-weight: 500;
    font-stretch: normal;
    font-style: normal;
    line-height: 1;
    letter-spacing: 0.36px;
    text-align: center;
    color: #ffffff;
}

@media ( max-width: 768px ) {
    body {
        margin: 0px;
    }

    #search-result-box {
        margin-top: 15px;
    }

    .search-itemDto {
        width: 330px;
        display: flex;
        flex-direction: row;
        align-content: center;
        justify-content: space-around;
    }

    .search-itemDto-left img {
        width: 80px;
        height: 80px;
    }

    .search-itemDto-center {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: space-evenly;
    }

    .search-itemDto-center div {
        width: 190px;
        height: 23px;
        font-size: 13px;
        font-weight: normal;
        font-stretch: normal;
        font-style: normal;
        line-height: 1.3;
        letter-spacing: -0.9px;
        text-align: left;
        color: #343a40;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
    }

    .search-itemDto-center div.price {
        height: 27px;
        font-size: 17px;
        font-weight: 600;
        font-stretch: normal;
        font-style: normal;
        line-height: 1;
        letter-spacing: -0.54px;
        text-align: left;
        color: #E8344E;
    }

    .search-itemDto-center span.unit {
        width: 17px;
        height: 18px;
        font-size: 14px;
        font-weight: 500;
        font-stretch: normal;
        font-style: normal;
        line-height: 1;
        letter-spacing: -0.9px;
        text-align: center;
        color: #000000;
    }

    .search-itemDto-right {
        display: inline-block;
        height: 100%;
        vertical-align: middle
    }

    .search-itemDto-right img {
        height: 14px;
        width: 14px;
        vertical-align: middle;
        margin-top: 26px;
        cursor: pointer;
        padding-right: 20px;
    }

    input#query {
        padding: 15px;
        width: 290px;
        border-radius: 2px;
        background-color: #e9ecef;
        border: none;

        background-image: url('../images/icon-search.png');
        background-repeat: no-repeat;
        background-position: right 10px center;
        background-size: 20px 20px;
    }

    input#query::placeholder {
        padding: 15px;
    }

    button {
        color: white;
        border-radius: 4px;
        border-radius: none;
    }

    .popup-container {
        display: none;
        position: fixed;
        top: 0;
        left: 0;
        bottom: 0;
        right: 0;
        background-color: rgba(0, 0, 0, 0.5);
        align-items: center;
        justify-content: center;
    }

    .popup-container.active {
        display: flex;
    }

    .popup {
        position: absolute;
        bottom: 0px;
        width: 333px;
        border-radius: 11px 11px 0px 0px;
    }

    .popup input {
        width: 278px !important;
        height: 39px;
        border-radius: 2px;
        border: solid 1.1px #dee2e6;
        margin-right: 9px;
        margin-bottom: 10px;
        padding-left: 10px;
    }

    .popup p {
        font-size: 14px;
    }

    .popup button.close {
        position: absolute;
        top: 15px;
        right: 15px;
        color: #adb5bd;
        background-color: #fff;
        font-size: 19px;
        border: none;
    }

    .popup button.cta {
        width: 319px;
        height: 43.9px;
        border-radius: 2px;
        background-color: #15aabf;
        border: none;
    }

    .popup button.cta2 {
        width: 302.1px;
        height: 43.9px;
        border-radius: 2px;
        background-color: #15aabf;
        border: none;
    }

    #search-area, #see-area {
        width: 330px;
        margin: auto;
    }

    .nav {
        width: 330px;
        margin: 30px auto;
        display: flex;
        align-items: center;
        justify-content: space-around;
    }

    .nav div {
        cursor: pointer;
    }

    .nav div.active {
        font-weight: 700;
    }

    .header {
        height: 255px;
        box-sizing: border-box;
        background-color: #15aabf;
        color: white;
        text-align: center;
        padding-top: 80px;
        /*padding: 50px;*/
        font-size: 45px;
        font-weight: bold;
    }

    .none {
        display: none;
    }

    input#kakao-login {
        padding: 15px;
        width: 526px;
        border-radius: 2px;
        background-color: #e9ecef;
        border: none;

        background-repeat: no-repeat;
        background-position: right 10px center;
        background-size: 20px 20px;
    }
}

.autocomplete {
    /*the container must be positioned relative:*/
    position: relative;
    display: inline-block;
}

input {
    border: 1px solid transparent;
    background-color: #f1f1f1;
    padding: 10px;
    font-size: 16px;
}

input[type=text] {
    background-color: #f1f1f1;
    /*width: 100%;*/
}

input[type=password] {
    background-color: #f1f1f1;
    /*width: 100%;*/
}
input[type=submit] {
    background-color: DodgerBlue;
    color: #fff;
}
.autocomplete-items {
    position: absolute;
    border: 1px solid #d4d4d4;
    border-bottom: none;
    border-top: none;
    z-index: 99;
    /*position the autocomplete items to be the same width as the container:*/
    top: 100%;
    left: 0;
    right: 0;
}
.autocomplete-items div {
    padding: 10px;
    cursor: pointer;
    background-color: #fff;
    border-bottom: 1px solid #d4d4d4;
}
.autocomplete-items div:hover {
    /*when hovering an item:*/
    background-color: #e9e9e9;
}
.autocomplete-active {
    /*when navigating through the items using the arrow keys:*/
    background-color: DodgerBlue !important;
    color: #ffffff;
}

.alert-danger {
    color: #721c24;
    background-color: #f8d7da;
    border-color: #f5c6cb;
}

.alert {
    width: 300px;
    margin-top: 22px;
    padding: 1.75rem 1.25rem;
    border: 1px solid transparent;
    border-radius: .25rem;
}