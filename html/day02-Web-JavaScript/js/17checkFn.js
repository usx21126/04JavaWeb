
export let check_username = (username_input) => {
  if (!/^\w{4,16}$/.test(username_input.value)) {
    document.querySelector('#name_msg').innerHTML = '用户名长度在4-16字符'
    return false
  } else {
    document.querySelector('#name_msg').innerHTML = ''
    return true
  }
}

export let check_phone = (phone_input) => {
  if (!/^(?:(?:\+|00)86)?1[3-9]\d{9}$/.test(phone_input.value)) {
    document.querySelector('#phone_msg').innerHTML = '手机号不能为空且长度为11位'
    return false
  } else {
    document.querySelector('#phone_msg').innerHTML = ''
    return true
  }
}

export let check_form = (event, username_input, phone_input) => {
  console.log(check_username(username_input));
  console.log(check_phone(phone_input));
  if (check_username(username_input) && check_phone(phone_input)) {
    console.log('submit!!!');
  } else {
    console.log('wrong');
    //组织表单提交
  }
  event.preventDefault();
}