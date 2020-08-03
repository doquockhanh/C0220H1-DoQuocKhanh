function searching() {
    document.getElementById('list-result').innerHTML = "";
    let kw = (<HTMLInputElement>document.getElementById('keyword')).value;

    fetch(`https://api.github.com/search/users?q=${kw}`)
        .then(res => {
            return res.json();
        })
        .then(data => {
            let insertLiTag = document.getElementById('list-result');
            insertLiTag.innerHTML += `<li><b>Total result: ${data.total_count}</b></li><hr>`;
            let i: any;
            for (i in data.items) {
                insertLiTag.innerHTML +=
                    `<li>Id: ${data.items[i].id}</li>
                            <li>Login: ${data.items[i].login}</li>
                            <li>Url: ${data.items[i].url}</li>
                            <li>Repositories url: ${data.items[i].repos_url}</li>
                            <li>Type: ${data.items[i].type}</li>
                            <hr>`;
            }
        });
}
