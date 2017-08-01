'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');
// end::vars[]

// tag::app[]
class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {accounts: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/accounts'}).done(response => {
			this.setState({accounts: response.entity._embedded.accounts});
		});
	}

	render() {
		return (
			<AccountList accounts={this.state.accounts}/>
		)
	}
}
// end::app[]

// tag::employee-list[]
class AccountList extends React.Component{
	render() {
		var accounts = this.props.accounts
			.map(account =>
				<Account key={account._links.self.href} account={account}/>
			);
		return (
			<table>
				<tbody>
					<tr>
						<th>Login ID</th>
						<th>User Name</th>
						<th>Email</th>
					</tr>
					{accounts}
				</tbody>
			</table>
		)
	}
}
// end::employee-list[]

// tag::employee[]
class Employee extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.account.loginId}</td>
				<td>{this.props.account.userName}</td>
				<td>{this.props.account.email}</td>
			</tr>
		)
	}
}
// end::employee[]

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]

