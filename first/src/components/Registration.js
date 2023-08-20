export default function Registration()
{
    return(
        <div className="container">
            <form action=" ">
                Enter Full Name : <input type="text" name="name"/><br/>
                Enter Address : <input type="text" name="add"/><br/>
                Enter City : <input type="text" name="ct"/><br/>
                Enter Pincode : <input type="number" name="pin"/><br/>
                Enter UserName : <input type="text" name="uname"/><br/>
                Enter Password : <input type="password" name="pwd"/><br/>
                Enter Role :<select>
                    <option>---select role---</option>
                    <option>Admin</option>
                    <option>Donor</option>
                    <option>Receiver</option>
                    </select><br/>
                <input type="submit" value="Register"/>
                <input type="reset" value="Clear"/>
            </form>
        </div>
    )
}