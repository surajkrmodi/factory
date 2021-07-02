import { useState } from "react";

function Userform(){

    const [user,setUser] = useState({name:'Suraj'});
    const saveUser = () => {

        const promise = fetch('http://localhost:8080/user',{
            method: 'POST',
            body: JSON.stringify(user),
            headers: {
                'content-type':'application/json'
            }
        });
        promise.then((response) => {
            console.log(response);
        })
        .catch((error) => {
            console.log(error);
        })
        console.log(user);
    
    }

    return(
        <div>
            <input value={user.name} onChange={(event) => {
                console.log(event.target.value);
                setUser({name:event.target.value})
            }
            }></input>
            <button onClick={saveUser}>Save</button>

        </div>
    )
}

export default Userform;