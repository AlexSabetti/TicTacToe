package com.codingdojo.tictactoe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.tictactoe.models.Match;
import com.codingdojo.tictactoe.models.Game;
import com.codingdojo.tictactoe.models.LoginUser;
import com.codingdojo.tictactoe.models.User;
import com.codingdojo.tictactoe.services.MatchService;
import com.codingdojo.tictactoe.services.UserService;
import com.codingdojo.tictactoe.services.GameService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private MatchService matchService;
	@Autowired
	private GameService gameService;
	@Autowired
	private HttpSession session;
	
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model) {
		userService.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		
		session.setAttribute("currentuser", newUser.getId());
		return "redirect:/games";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model) {
		User user = userService.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		session.setAttribute("currentuser", user.getId());
		return "redirect:/games";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		if(session.getAttribute("currentuser") == null) {
			model.addAttribute("warning", "You are not logged in, please log in.");
			return "redirect:/";
		} else {
			User user = userService.findUserById((long)session.getAttribute("currentuser"));
			model.addAttribute("user", user);
			model.addAttribute("users", userService.findUsers());
			return "home.jsp";
		}
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/games")
	public String games(Model model) {
		if (session.getAttribute("currentuser") == null) {
			return "redirect:/";
		} else {
			List<Game> games = gameService.allGames();
			model.addAttribute("games", games);
			model.addAttribute("user", userService.findUserById((long)session.getAttribute("currentuser")));
			return "home.jsp";
		}
	}
	
	@GetMapping("/games/{gameId}/home")
	public String show(@PathVariable("gameId") Long gameId, Model model) {
		if (session.getAttribute("currentuser") == null) {
			return "redirect:/";
		} else {
			Game game = gameService.findGame(gameId);
			model.addAttribute("game", game);
			model.addAttribute("matches", matchService.allGameSpecificMatches(gameId));
			model.addAttribute("user", userService.findUserById((long) session.getAttribute("currentuser")));
			String specificGameHomePath = "home" + game.getName() + ".jsp";
			return specificGameHomePath;
		}
	}
	
	
	@PostMapping("/games/{gameId}/home/matches/new")
	public String createBook(@PathVariable("gameId") Long id, @Valid @ModelAttribute("newMatch") Match newMatch, BindingResult result, Model model) {
		if (session.getAttribute("currentuser") == null) {
			return "redirect:/";
		} else {
			if(result.hasErrors()) {
				System.out.println(result.getAllErrors());
				model.addAttribute("newMatch", newMatch);
				return "redirect:/games/" + id + "/home";
			} else {
				newMatch.setChallenger(userService.findUserById((long) session.getAttribute("currentuser")));
				newMatch.setGame(gameService.findGame(id));
				newMatch.setInfo(222222222);
				matchService.createMatch(newMatch);
				String toPath = "redirect:/games/" + id + "/home";
				return toPath;
			}
		}
	}
	
	@GetMapping("/games/{gameId}/home/matches/{matchId}/join")
	public String joinMatch(@PathVariable("gameId") Long gameId, @PathVariable("matchId") Long matchId, Model model) {
		if (session.getAttribute("currentuser") == null) {
			return "redirect:/";
		} else {
			Match match = matchService.findMatch(matchId);
			if(match.getChallengee() != null && match.getChallenger().getId() != (long) session.getAttribute("currentuser")) {
				return "redirect:/games/" + gameId + "/home";
			} else {
				match.setChallengee(userService.findUserById((long) session.getAttribute("currentuser")));
				match.setId(matchId);
				matchService.updateMatch(match);
				return "redirect:/games/" + gameId + "/home";
			}
		}
	}
	
}
