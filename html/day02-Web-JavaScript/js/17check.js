import * as check from './17checkFn.js'
let username_input = document.querySelector('#username')
let phone_input = document.querySelector('#phone')
let form = document.querySelector('form')

username_input.addEventListener('blur', () => check.check_username(username_input))
phone_input.addEventListener('blur', () => check.check_phone(phone_input))
form.addEventListener('submit', (e) => check.check_form(e, username_input, phone_input))